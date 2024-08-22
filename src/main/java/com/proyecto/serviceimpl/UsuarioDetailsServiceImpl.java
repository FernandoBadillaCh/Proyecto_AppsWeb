package com.proyecto.serviceimpl;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.Rol;
import com.proyecto.domain.Usuario;
import com.proyecto.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private HttpSession session;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		// Se busca el usuario que tiene el username pasado por parámetro...
		Usuario usuario = usuarioDao.findByCorreo(correo);

		// Se valida si se recuperó un usuario; si no, lanza un error
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo);
		}

		// Se obtiene el rol del usuario y se crea la autoridad de seguridad de Spring
		GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre());

		// Se retorna un User (de tipo UserDetails)
		return new User(usuario.getCorreo(), usuario.getClave(), List.of(authority));
	}


}
