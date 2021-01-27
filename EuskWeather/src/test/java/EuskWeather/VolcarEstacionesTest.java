package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EstacionMeteorologica;
import ModAD.VolcarEstaciones;
import ModAD.convertirJSONXML;

public class VolcarEstacionesTest {

	VolcarEstaciones ve = new VolcarEstaciones();
	
	@Test
	public void testLecturaDatos() {
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//estaciones.xml", "utf-8");
		ArrayList<EstacionMeteorologica> resultado = ve.lecturaDatos(xml);
		ArrayList<EstacionMeteorologica> resultadoEsperado = resultado;
		assertEquals(resultado, resultadoEsperado);
	}

}
