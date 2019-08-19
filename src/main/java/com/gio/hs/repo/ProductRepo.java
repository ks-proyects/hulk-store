package com.gio.hs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gio.hs.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

	public Product findByCodigo(String codigo);
}
