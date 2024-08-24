package com.proyecto;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
}
