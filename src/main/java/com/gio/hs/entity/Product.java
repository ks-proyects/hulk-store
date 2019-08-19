package com.gio.hs.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String codigo;

	@Column(nullable = false)
	private String tipo;

	@Column(nullable = false)
	private Integer cantidad;

	@Column(nullable = false)
	private BigDecimal valorUnidad;

	@OneToMany(targetEntity = CarItem.class, mappedBy = "product", fetch = FetchType.EAGER)
	private Set<CarItem> carItems;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Set<CarItem> getCarItems() {
		return carItems;
	}

	public void setCarItems(Set<CarItem> carItems) {
		this.carItems = carItems;
	}

}
