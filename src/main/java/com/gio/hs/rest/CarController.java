package com.gio.hs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gio.hs.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService ordenService;

	@GetMapping("/add/{codigo}/{cantidad}")
	public ResponseEntity<?> addToCar(Pageable pageable, @PathVariable("codigo") String codigo,
			@PathVariable("cantidad") Integer cantidad) {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String currentUserName = "";
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				currentUserName = authentication.getName();
			}
			return ResponseEntity.status(HttpStatus.OK).body(ordenService.addItem(currentUserName, codigo, cantidad));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("error");
		}
	}

	@GetMapping("/delete/{codigo}")
	public ResponseEntity<?> deleteCar(Pageable pageable, @PathVariable("codigo") String codigo) {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = "";
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				username = authentication.getName();
			}
			return ResponseEntity.status(HttpStatus.OK).body(ordenService.removeItem(username, codigo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("error");
		}
	}
}
