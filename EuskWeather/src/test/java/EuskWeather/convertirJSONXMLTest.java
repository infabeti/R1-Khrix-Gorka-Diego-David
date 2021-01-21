package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.convertirJSONXML;

public class convertirJSONXMLTest {

	convertirJSONXML conversor = new convertirJSONXML();
	
	@Test
	public void testLeerArchivo() {
		String resultado = convertirJSONXML.leerArchivo("./archJSON//testJSON.json", "Windows-1252");
		String resultadoEsperado = "jsonCallback([ {Prueba} ]);";
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testRepararJSONSinCabecera() {
		String resultado = convertirJSONXML.repararJSONSinCabecera("jsonCallback([ {Prueba} ]);", "Prueba");
		String resultadoEsperado = "{\n" + "\"Prueba\": [ \n" + "{Prueba\n" + "}\n" + "]\n" + "}";
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testRepararJSONSinCabecera2() {
		String resultado = convertirJSONXML.repararJSONSinCabecera("{Prueba}{Prueba}{Prueba}]);", "Prueba");
		String resultadoEsperado = "{Prueba\n" + "}{Prueba\n" + "}{Prueba}\n" + "]\n" + "}";
		assertEquals(resultado, resultadoEsperado);
	}
	
	@Test
	public void testDistinguirEtiquetasRepes() {
		String resultado = convertirJSONXML.distinguirEtiquetasRepes("{\"test\" : \"prueba etiqueta repe1"
																	+ "  \"test\" : \"prueba repe2"
																	+ "\"nodoTest\" : \"\",\"nodoTest\" : \"\","
																	+ "\"psp\" : \"\",\"psp\" : \"\",}]);");
		String resultadoEsperado = " }]); ]\n" + "}";
		assertEquals(resultado, resultadoEsperado);
	}
	
	

}
