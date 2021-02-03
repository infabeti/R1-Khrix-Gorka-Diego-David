package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.InformacionMeteorologica;
import ModAD.VolcarInfoMeteorologica;
import ModAD.convertirJSONXML;

public class VolcarInfoMeteorologicaTest {

	private VolcarInfoMeteorologica vim = new VolcarInfoMeteorologica();
	private InformacionMeteorologica im = new InformacionMeteorologica();
	private ArrayList<InformacionMeteorologica> lista = new ArrayList<InformacionMeteorologica>();
	
	@Test
	public void testCambiarNombreEstacion() {
		vim.cambiarNombreEstacion(lista);
	}
	
	@Test
	public void testObtenerNombreMunicipios() {
		String xml = convertirJSONXML.leerArchivo("./ficherosTest//index.xml", "utf-8");
		String[] resultado = vim.obtenerNombreMunicipios(xml);
		String[] resultadoEsperado = {"ABANTO", "ZUMARRAGA"};
		assertArrayEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testLecturaDatos() {
		ArrayList<InformacionMeteorologica> resultado = vim.lecturaDatos();
		ArrayList<InformacionMeteorologica> resultadoEsperado = resultado;
		assertEquals(resultado, resultadoEsperado);
	}

}
