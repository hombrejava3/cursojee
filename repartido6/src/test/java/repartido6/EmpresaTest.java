package repartido6;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.microforum.repartido6.EmpleadoAnual;
import com.microforum.repartido6.EmpleadoHora;
import com.microforum.repartido6.Empresa;
import com.microforum.repartido6.Liquidable;

public class EmpresaTest {
	@Test
	public void test() {
		List<Liquidable> liquidables = new ArrayList<Liquidable>();
		liquidables.add(new EmpleadoAnual("nom1", "dni1", "dir1", 12000));
		liquidables.add(new EmpleadoHora("nom2", "dni2", "dir2", 10, 160));
		Empresa empresa = new Empresa("empresa1", liquidables);
		assertTrue(empresa.calcularTotalPagosMensuales() == 2600);
	}
}
