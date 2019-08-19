package com.gio.hs.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gio.hs.repo.EmployedRepo;

@Service
public class EmployedService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(EmployedService.class);

	private final EmployedRepo usuarioRepo;

	@Autowired
	public EmployedService(EmployedRepo usuarioRepo) {

		this.usuarioRepo = usuarioRepo;
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			logger.debug(username);
			com.gio.hs.entity.Employed us = usuarioRepo.findByUsernameAndActivo(username, true);
			UserDetails user = null;
			if (us != null)
				user = User.withDefaultPasswordEncoder().username(us.getUsername()).password(us.getPassword())
						.authorities(buildGranted(us.getRol())).build();
			return user;

		} catch (Exception e) {
		}
		return null;
	}

	private List<GrantedAuthority> buildGranted(byte rol) {
		String roles[] = { "LECTOR", "USER", "ADMINISTRADOR" };
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (int i = 0; i < rol; i++) {
			authorities.add(new SimpleGrantedAuthority(roles[i]));
		}
		return authorities;
	}
}
