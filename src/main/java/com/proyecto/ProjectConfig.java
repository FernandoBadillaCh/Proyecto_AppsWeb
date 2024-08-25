package com.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
						.requestMatchers("/","/index","/errores/**",
								"/carrito/**","/pruebas/**","/reportes/**",
								"/registro/**","/js/**","/webjars/**"
								,"/categoria/**"
								,"/producto/**"
								,"/registro/**"
								,"/reservas/**")
						.permitAll().requestMatchers("/reservas/**","/reservas/nueva","/reservas/guardar" ).authenticated()
				).formLogin((form) -> form
						.loginPage("/login").permitAll())
				.logout((logout) -> logout.permitAll());
		return http.build();
	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
