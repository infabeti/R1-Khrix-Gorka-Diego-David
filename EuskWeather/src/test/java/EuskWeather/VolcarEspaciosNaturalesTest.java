package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EspaciosNaturales;
import ModAD.VolcarEspaciosNaturales;
import ModAD.convertirJSONXML;

public class VolcarEspaciosNaturalesTest {

	VolcarEspaciosNaturales ven = new VolcarEspaciosNaturales();
	EspaciosNaturales en = new EspaciosNaturales(1, "Embalse de Ull�barri-Gamboa", "Emplazado en el municipio alav�s de�Arrazua-Ubarrundia, el embalse de�Ull&amp;iacute...", "Pantanos", "Getxo");
	
	@Test
	public void test() {
		String xml = convertirJSONXML.leerArchivo("./ficherosTest//espacios-naturales.xml", "utf-8");
		ArrayList<EspaciosNaturales> resultado = ven.lecturaDatos(xml);
		ArrayList<EspaciosNaturales> resultadoEsperado = new ArrayList();
		resultadoEsperado.add(en);
		assertEquals(resultado.get(0).getTipo(), resultadoEsperado.get(0).getTipo());
	}

}
