package com.gio.hs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gio.hs.entity.Car;
import com.gio.hs.entity.Employed;
import com.gio.hs.enums.EstadoOrden;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer>, PagingAndSortingRepository<Car, Integer> {

	public Car findByEstadoAndEmployed(EstadoOrden estado, Employed employed);
}
