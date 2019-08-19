package com.gio.hs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gio.hs.dto.GenericResponse;
import com.gio.hs.dto.ProductDTO;
import com.gio.hs.service.ProductService;

@RestController
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all-items")
	public ResponseEntity<?> findAll(Pageable pageable) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("error");
		}
	}

	@PostMapping("/update-stock")
	public ResponseEntity<?> generateCitByPaciente(@RequestBody ProductDTO dto) {
		GenericResponse response = new GenericResponse();
		response.setCode(0);
		try {
			response.setData(productService.updateStock(dto.getCodigo(), dto.getCantidad()));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			response.setCode(1);
			response.setMsg(e.getMessage());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

}
