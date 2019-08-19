package com.gio.hs.service;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gio.hs.dto.GenericResponse;
import com.gio.hs.entity.Car;
import com.gio.hs.entity.CarItem;
import com.gio.hs.entity.Employed;
import com.gio.hs.entity.Product;
import com.gio.hs.enums.EstadoOrden;
import com.gio.hs.repo.CarItemRepo;
import com.gio.hs.repo.CarRepo;
import com.gio.hs.repo.EmployedRepo;
import com.gio.hs.repo.ProductRepo;

@Service
public class CarService {

	@Autowired
	private ProductRepo productoRepo;

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private CarItemRepo carItemRepo;

	@Autowired
	private EmployedRepo employedRepo;

	public GenericResponse addItem(String username, String codigo, Integer cantidad) {
		GenericResponse response = new GenericResponse();
		response.setCode(0);
		try {
			Product product = productoRepo.findByCodigo(codigo);
			if(product==null)
				throw new Exception("No existe el item.");
			if (product.getCantidad() < cantidad) {
				throw new Exception("No tiene stock el item.");
			}
			Employed employed = employedRepo.findByUsernameAndActivo(username, true);
			Car car = carRepo.findByEstadoAndEmployed(EstadoOrden.ING, employed);
			CarItem carItem = null;
			if (car == null) {
				car = new Car();
				car.setEmployed(employed);
				car.setEstado(EstadoOrden.ING);
				car.setFechaIngreso(Calendar.getInstance().getTime());
				car.setTotalCompra(BigDecimal.valueOf(0.0));
				car = carRepo.save(car);
			} else {
				carItem = carItemRepo.findByProductAndCar(product, car);
			}
			// Validamos existencia en el carrito
			if (carItem == null) {
				carItem = new CarItem();
				carItem.setCantidad(cantidad);
				carItem.setCar(car);
				carItem.setProduct(product);
				carItem.setValorUnidad(product.getValorUnidad());
			} else {
				carItem.setCantidad(carItem.getCantidad() + cantidad);
			}
			carItem = carItemRepo.save(carItem);
			// Actualizamos el stock
			product.setCantidad(product.getCantidad() - cantidad);
			productoRepo.save(product);
			response.setData(car);
		} catch (Exception e) {
			response.setMsg(e.getMessage());
			response.setCode(1);
		}
		return response;
	}

	public GenericResponse removeItem(String username, String codigo) {
		GenericResponse response = new GenericResponse();
		response.setCode(0);
		try {
			Product product = productoRepo.findByCodigo(codigo);
			Employed employed = employedRepo.findByUsernameAndActivo(username, true);
			Car car = carRepo.findByEstadoAndEmployed(EstadoOrden.ING, employed);
			if (car != null) {
				CarItem carItem = carItemRepo.findByProductAndCar(product, car);
				product.setCantidad(product.getCantidad() + carItem.getCantidad());
				productoRepo.save(product);
				carItemRepo.delete(carItem);
			}
		} catch (Exception e) {
			response.setMsg(e.getMessage());
			response.setCode(1);
		}
		return response;
	}

}
