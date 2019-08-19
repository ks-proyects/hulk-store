package com.gio.hs.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gio.hs.enums.EstadoOrden;

@Entity
public class Car {

	@Id
	@GeneratedValue(generator = "sqlite")
	@TableGenerator(name = "sqlite", table = "hs_sequence", pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "car")
	private Integer id;

	@Column
	private String numero;

	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaPago;

	@Column
	private BigDecimal totalCompra;

	@Column
	@Enumerated(EnumType.STRING)
	private EstadoOrden estado;

	@ManyToOne
	@JoinColumn(name = "id_employed")
	private Employed employed;

	@OneToMany(targetEntity = CarItem.class, mappedBy = "car", fetch = FetchType.EAGER)
	private Set<CarItem> carItems;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public Employed getEmployed() {
		return employed;
	}

	public void setEmployed(Employed employed) {
		this.employed = employed;
	}

	public Set<CarItem> getCarItems() {
		return carItems;
	}

	public void setCarItems(Set<CarItem> carItems) {
		this.carItems = carItems;
	}

}
