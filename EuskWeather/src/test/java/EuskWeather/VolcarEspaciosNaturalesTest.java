package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EspacioNatural;
import ModAD.VolcarEspaciosNaturales;
import ModAD.convertirJSONXML;

public class VolcarEspaciosNaturalesTest {

	VolcarEspaciosNaturales ven = new VolcarEspaciosNaturales();
	EspacioNatural en = new EspacioNatural(1, "Embalse de Ullíbarri-Gamboa", "Emplazado en el municipio alavés de Arrazua-Ubarrundia, el embalse de Ull&amp;iacute...", "Pantanos", "Getxo");
	
	@Test
	public void test() {
		String xml = convertirJSONXML.leerArchivo("./ficherosTest//espacios-naturales.xml", "utf-8");
		ArrayList<EspacioNatural> resultado = ven.lecturaDatos(xml);
		ArrayList<EspacioNatural> resultadoEsperado = new ArrayList();
		resultadoEsperado.add(en);
		assertEquals(resultado.get(0).getTipo(), resultadoEsperado.get(0).getTipo());
	}

}
