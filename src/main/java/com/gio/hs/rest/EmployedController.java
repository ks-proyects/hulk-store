package com.gio.hs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gio.hs.repo.EmployedRepo;

@RestController
@RequestMapping("/sec")
public class EmployedController {

	@Autowired
	private EmployedRepo userRepo;
	@GetMapping("/users")
	public ResponseEntity<?> findMedicByEspecialidadAndCiudadAndFecha(Pageable pageable) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("error");
		}
	}
}
