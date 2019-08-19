package com.gio.hs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gio.hs.entity.Car;
import com.gio.hs.entity.CarItem;
import com.gio.hs.entity.Product;

@Repository
public interface CarItemRepo
		extends JpaRepository<CarItem, Integer>, PagingAndSortingRepository<CarItem	, Integer> {

	public CarItem findByProductAndCar(Product producto,Car car);
}
