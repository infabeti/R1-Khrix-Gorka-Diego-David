package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EstacionMeteorologica;
import ModAD.VolcarEstaciones;
import ModAD.convertirJSONXML;

public class VolcarEstacionesTest {

	VolcarEstaciones ve = new VolcarEstaciones();
	EstacionMeteorologica em = new EstacionMeteorologica(1, "ALGORTA (BBIZI2)", 43.362055748944286, -3.0227822073211765, "Carretera de Galea, s/n ", "Getxo");
	
	@Test
	public void testLecturaDatos() {
		String xml = convertirJSONXML.leerArchivo("./ficherosTest//estaciones.xml", "utf-8");
		ArrayList<EstacionMeteorologica> resultado = ve.lecturaDatos(xml);
		ArrayList<EstacionMeteorologica> resultadoEsperado = new ArrayList();
		resultadoEsperado.add(em);
		assertEquals(resultado.get(0).getLatidud(), resultadoEsperado.get(0).getLatidud(), 1);
	}

}
