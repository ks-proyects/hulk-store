package com.gio.hs.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity(name = "car_item")
public class CarItem {

	@Id
	@GeneratedValue(generator = "sqlite-item")
	@TableGenerator(name = "sqlite-item", table = "hs_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "car-item")
	private Integer id;

	@Column(nullable = false)
	private Integer cantidad;

	@Column(nullable = false)
	private BigDecimal valorUnidad;

	@ManyToOne
	@JoinColumn(name = "id_car")
	private Car car;

	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	public CarItem() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(BigDecimal valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
