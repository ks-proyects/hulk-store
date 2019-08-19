package com.gio.hs.enums;

public enum EstadoOrden {

	ING("INGRESAO"), PROC("PROCESO"), PAG("PAGADO");

	private final String descripcion;

	EstadoOrden(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
