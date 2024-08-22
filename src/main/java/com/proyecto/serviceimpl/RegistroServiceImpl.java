package com.proyecto.serviceimpl;
import com.proyecto.domain.Usuario;
import com.proyecto.service.CorreoService;
import com.proyecto.service.RegistroService;
import com.proyecto.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private CorreoService correoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private FirebaseStorageServiceImpl firebaseStorageService;

	@Value("${servidor.http}")
	private String servidor;

	@Override
	public Model activar(Model model, String correo, String clave) {
		Usuario usuario = usuarioService.getUsuarioPorCorreoYClave(correo, clave);
		if (usuario != null) {
			model.addAttribute("usuario", usuario);
		} else {
			model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
			model.addAttribute("mensaje", messageSource.getMessage("registro.activar.error", null, Locale.getDefault()));
		}
		return model;
	}

	@Override
	public void activar(Usuario usuario) {
		var encoder = new BCryptPasswordEncoder();
		usuario.setClave(encoder.encode(usuario.getClave()));
		usuarioService.save(usuario);
	}

	@Override
	public Model crearUsuario(Model model, Usuario usuario) throws MessagingException {
		String mensaje;
		if (!usuarioService.existeUsuarioPorCorreo(usuario.getCorreo())) {
			String clave = demeClave();
			usuario.setClave(clave);
			usuarioService.save(usuario);

			enviaCorreoActivar(usuario, clave);
			mensaje = String.format(messageSource.getMessage("registro.mensaje.activacion.ok", null, Locale.getDefault()), usuario.getCorreo());
		} else {
			mensaje = String.format(messageSource.getMessage("registro.mensaje.usuario.o.correo", null, Locale.getDefault()), usuario.getCorreo());
		}
		model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
		model.addAttribute("mensaje", mensaje);
		return model;
	}

	@Override
	public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException {
		String mensaje;
		Usuario usuario2 = usuarioService.getUsuarioPorCorreo(usuario.getCorreo());

		if (usuario2 != null) {
			String clave = demeClave();
			usuario2.setClave(clave);
			usuarioService.save(usuario2);

			enviaCorreoRecordar(usuario2, clave);
			mensaje = String.format(messageSource.getMessage("registro.mensaje.recordar.ok", null, Locale.getDefault()), usuario.getCorreo());
		} else {
			mensaje = String.format(messageSource.getMessage("registro.mensaje.usuario.o.correo", null, Locale.getDefault()), usuario.getCorreo());
		}
		model.addAttribute("titulo", messageSource.getMessage("registro.activar", null, Locale.getDefault()));
		model.addAttribute("mensaje", mensaje);
		return model;
	}

	private String demeClave() {
		String tira = "ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijklmnopqrstuvwxyz0123456789_*+-";
		StringBuilder clave = new StringBuilder();
		for (int i = 0; i < 40; i++) {
			clave.append(tira.charAt((int) (Math.random() * tira.length())));
		}
		return clave.toString();
	}

	private void enviaCorreoActivar(Usuario usuario, String clave) throws MessagingException {
		String mensaje = String.format(messageSource.getMessage("registro.correo.activar", null, Locale.getDefault()),
				usuario.getNombre(), servidor, usuario.getCorreo(), clave);
		String asunto = messageSource.getMessage("registro.mensaje.activacion", null, Locale.getDefault());
		correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);
	}

	private void enviaCorreoRecordar(Usuario usuario, String clave) throws MessagingException {
		String mensaje = String.format(messageSource.getMessage("registro.correo.recordar", null, Locale.getDefault()),
				usuario.getNombre(), servidor, usuario.getCorreo(), clave);
		String asunto = messageSource.getMessage("registro.mensaje.recordar", null, Locale.getDefault());
		correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);
	}
}

