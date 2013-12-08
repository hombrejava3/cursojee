package com.microforum.repartido6;

public class EmpleadoAnual extends Empleado {
	private double salarioAnual;

	public double getSalarioAnual() {
		return salarioAnual;
	}

	public void setSalarioAnual(double salarioAnual) {
		this.salarioAnual = salarioAnual;
	}

	public EmpleadoAnual(String nombre, String dni, String direccion, double salarioAnual) {
		super(nombre, dni, direccion);
		this.salarioAnual = salarioAnual;
	}

	public double getCostoMensual() {
		return salarioAnual / 12;
	}

	@Override
	public String toString() {
		return "EmpleadoAnual [salarioAnual=" + salarioAnual + ", getNombre()=" + getNombre() + ", getDni()=" + getDni() + ", getDireccion()=" + getDireccion()
				+ "]";
	}
}
