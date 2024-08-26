package com.proyecto.serviceimpl;

import com.proyecto.dao.UsuarioDao;
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

import java.util.Collections;

@Service
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private HttpSession session;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Se busca el usuario que tiene el username pasado por parámetro
		Usuario usuario = usuarioDao.findByUsername(username);

		// Se valida si se recuperó un usuario / si no lanza un error
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado: " + username);
		}

		// Se obtiene el rol del usuario
		String rol = usuario.getRol();
		// Se convierte el rol en un GrantedAuthority
		GrantedAuthority authority = new SimpleGrantedAuthority(rol);

		// Se retorna un User (de tipo UserDetails) con el rol asociado
		return new User(usuario.getUsername(), usuario.getClave(), Collections.singleton(authority));
	}

}
