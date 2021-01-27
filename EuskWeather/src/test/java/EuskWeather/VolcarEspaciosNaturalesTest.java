package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EspacioNatural;
import ModAD.VolcarEspaciosNaturales;
import ModAD.convertirJSONXML;

public class VolcarEspaciosNaturalesTest {

	VolcarEspaciosNaturales ven = new VolcarEspaciosNaturales();
	
	@Test
	public void test() {
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//espacios-naturales.xml", "utf-8");
		ArrayList<EspacioNatural> resultado = ven.lecturaDatos(xml);
		ArrayList<EspacioNatural> resultadoEsperado = resultado;
		assertEquals(resultado, resultadoEsperado);
	}

}
