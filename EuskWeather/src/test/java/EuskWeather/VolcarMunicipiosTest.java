package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.Municipios;
import ModAD.VolcarMunicipios;
import ModAD.convertirJSONXML;

public class VolcarMunicipiosTest {

	VolcarMunicipios vm = new VolcarMunicipios();
	Municipios m = new Municipios(20, 1, "Aduna", "JOSU AMILIBIA ALSUA", "www.aduna.eus");
	
	@Test
	public void testLecturaDatos() {
		String xml = convertirJSONXML.leerArchivo("./ficherosTest//municipios.xml", "utf-8");
		ArrayList<Municipios> resultado = vm.lecturaDatos(xml);
		ArrayList<Municipios> resultadoEsperado = new ArrayList();
		resultadoEsperado.add(m);
		assertEquals(resultado.get(0).getNombreMuni(), resultadoEsperado.get(0).getNombreMuni());
	}

	@Test
	public void testVolcarInformacion() {
		ArrayList<Municipios> objeto = new ArrayList<Municipios>();
		vm.volcarInformacion(objeto);
	}
	
}
