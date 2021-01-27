package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.Municipios;
import ModAD.VolcarMunicipios;
import ModAD.convertirJSONXML;

public class VolcarMunicipiosTest {

	VolcarMunicipios vm = new VolcarMunicipios();
	
	@Test
	public void testLecturaDatos() {
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//municipios.xml", "utf-8");
		ArrayList<Municipios> resultado = vm.lecturaDatos(xml);
		ArrayList<Municipios> resultadoEsperado = resultado;
		assertEquals(resultado, resultadoEsperado);
	}

}
