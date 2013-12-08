package com.microforum.repartido6;

public class EmpleadoHora extends Empleado {
	private double valorHora;
	private double cantidadHoras;

	public EmpleadoHora(String nombre, String dni, String direccion, double valorHora, double cantidadHoras) {
		super(nombre, dni, direccion);
		this.valorHora = valorHora;
		this.cantidadHoras = cantidadHoras;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(double cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	@Override
	public double getCostoMensual() {
		// TODO Auto-generated method stub
		return cantidadHoras * valorHora;
	}

	@Override
	public String toString() {
		return "EmpleadoHora [valorHora=" + valorHora + ", cantidadHoras=" + cantidadHoras + ", getNombre()=" + getNombre() + ", getDni()=" + getDni()
				+ ", getDireccion()=" + getDireccion() + "]";
	}
}
