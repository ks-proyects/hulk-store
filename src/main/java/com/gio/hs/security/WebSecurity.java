package com.gio.hs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private EmployedService usuarioService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
		auth.userDetailsService(usuarioService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login","/sec").permitAll()
				// permitimos el acceso a /login a cualquiera
				.anyRequest().authenticated().// cualquier otra peticion requiere autentifcacion
				and()
				// las peticiones /login pasaran previamente por este filtro
				.addFilterBefore(new LoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// las demas peticiones pasaran por este filtro para validar el token
				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
