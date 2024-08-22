package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

	//Estos metodos son para la implementacion de la internacionalizacion
	//LocalResolver se utiliza para crear una sesion de cambio de idioma
	@Bean
	public LocaleResolver localeResolver(){
		var slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.getDefault());
		slr.setLocaleAttributeName("session.current.locale");
		slr.setTimeZoneAttributeName("session.current.timezone");
		return slr;
	}

	//LocaleChangeInterceptor se utiliza para crear un interceptor de cambio de idioma
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		var lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry){
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}

	//Bean para poder acceder a los Messages.properties
	@Bean("messageSource")
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((request) -> request
						.requestMatchers(
								"/",
								"/index",
								"/errores/**",
								"/carrito/**",
								"/pruebas/**",
								"/reportes/**",
								"/registro/**",
								"/js/**",
								"/webjars/**",
								"/categoria/**",
								"/producto/**",
								"/actuator/mappings",
								"/administrarusuarios/**",
								"/administrarusuarios/modifica",
								"/usuario/**",
								"/producto/nuevo",
								"/producto/guardar",
								"/producto/modificar/**",
								"/producto/eliminar/**",
								"/categoria/nuevo",
								"/categoria/guardar",
								"/categoria/modificar/**",
								"/categoria/eliminar/**",
								"/facturar/carrito"
						)
						.permitAll()
				)
				.formLogin((form) -> form
						.loginPage("/login").permitAll()
				)
				.logout((logout) -> logout
						.permitAll()
				);
		return http.build();
	}


	//El siguiente método se utiliza para completar la clase no es
	//	realmente funcional, la próxima semana se reemplaza con usuarios de BD
	@Bean
	public UserDetailsService users() {
		UserDetails admin = User.builder()
				.username("juan")
				.password("{noop}123")
				.roles("ADMIN")
				.build();
		UserDetails sales = User.builder()
				.username("rebeca")
				.password("{noop}456")
				.roles("USER", "VENDEDOR")
				.build();
		UserDetails user = User.builder()
				.username("pedro")
				.password("{noop}789")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user, sales, admin);
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}

/*Error Handling

GET /error (Basic error handling)
Static Resources

/webjars/**
/**
Controladores
CategoriaController

GET /categoria/listado — Listar categorías
GET /categoria/administrarcategorias — Administrar categorías
GET /categoria/eliminar/{idCategoria} — Eliminar categoría por ID
GET /categoria/lista/{idCategoria} — Detalle de categoría
POST /categoria/guardar — Guardar categoría
ProductoController

GET /producto/listado — Listar productos
GET /producto/{idProducto} — Detalle de producto
POST /producto/guardar — Guardar producto
GET /producto/eliminar/{idProducto} — Eliminar producto por ID
UsuarioController

GET /administrarusuarios — Administrar usuarios
POST /register — Registrar usuario
POST /modifica — Modificar usuario
RegistroController

GET /registro/crear — Crear nuevo usuario (formulario)
POST /registro/crear — Crear nuevo usuario
GET /registro/activar — Activar usuario (por email y token)
POST /registro/activar — Activar usuario (con objeto Usuario)
GET /registro/recordar — Recordar usuario (formulario)
POST /registro/recordar — Recordar usuario (con objeto Usuario)
PruebasController

POST /pruebas/query1 — Ejecutar consulta query1
GET /pruebas/listado — Listado de pruebas
GET /pruebas/listado2 — Listado de pruebas (variante)
GET /pruebas/listado/{idCategoria} — Listado de pruebas filtrado por categoría
NuevaReservacionController

GET /NuevaReservacion/NuevaReservacion — Crear nueva reservación (formulario)
POST /NuevaReservacion/guardar — Guardar nueva reservación
reservaslistadoController

GET /reservaslistado/listado — Listar reservaciones
POST /reservaslistado/guardar — Guardar reservación
IndexController

GET / — Página de inicio
Vistas Estáticas
/index — Página de inicio
/login — Página de login
/registro/nuevo — Formulario para nuevo registro

 */
