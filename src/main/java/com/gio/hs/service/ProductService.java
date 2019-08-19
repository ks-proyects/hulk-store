package com.gio.hs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gio.hs.entity.Product;
import com.gio.hs.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> findAll() {
		return productRepo.findAll();
	}

	public Product updateStock(String codigo, Integer cantidad) throws Exception {
		Product product = productRepo.findByCodigo(codigo);
		product.setCantidad(product.getCantidad()+cantidad);
		productRepo.save(product);
		return product;
	}
}
