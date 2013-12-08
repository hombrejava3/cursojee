package com.microforum.repartido6;

import java.util.List;

public class Empresa {
	private String nombre;
	private List<Liquidable> liquidables;

	public double calcularTotalPagosMensuales() {
		double resultado = 0;
		for (Liquidable liquidable : liquidables) {
			resultado += liquidable.getCostoMensual();
		}
		return resultado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Liquidable> getLiquidables() {
		return liquidables;
	}

	public void setLiquidables(List<Liquidable> liquidables) {
		this.liquidables = liquidables;
	}

	public Empresa(String nombre, List<Liquidable> liquidables) {
		super();
		this.nombre = nombre;
		this.liquidables = liquidables;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", liquidables=" + liquidables + "]";
	}
}
