package EuskWeather;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ModAD.InfoMeteorologica;

public class InfoMeteorologicaTest {

	private InfoMeteorologica infMetVacio = new InfoMeteorologica();
	private InfoMeteorologica infMetParam = new InfoMeteorologica(1, "1-1-2020", "24:00", "2.4", "5", 2, "Buena", "ZUMARRAGA");
	
	@Test
	public void testConstructor() {
		assertEquals(infMetParam.getIdInfo(), 1);
		assertEquals(infMetParam.getFecha(), "1-1-2020");
		assertEquals(infMetParam.getHora(), "24:00");
		assertEquals(infMetParam.getPresionAtm(), "2.4");
		assertEquals(infMetParam.getTemperatura(), "5");
		assertEquals(infMetParam.getSaturacionO2(), 2);
		assertEquals(infMetParam.getNomEstMet(), "ZUMARRAGA");
	}
	
	@Test
	public void testGetSetNomEstMet() {
		infMetVacio.setNomEstMet("Prueba");
		assertEquals(infMetVacio.getNomEstMet(), "Prueba");
	}
	
	@Test
	public void testGetSetIdInfo() {
		infMetVacio.setIdInfo(1);
		assertEquals(infMetVacio.getIdInfo(), 1);
	}
	
	@Test
	public void testGetSetFecha() {
		infMetVacio.setFecha("2020-11-23");
		assertEquals(infMetVacio.getFecha(), "2020-11-23");
	}
	
	@Test
	public void testGetSetPresionAtm() {
		infMetVacio.setPresionAtm("5.2");
		assertEquals(infMetVacio.getPresionAtm(), "5.2");
	}
	
	@Test
	public void testGetSetTemperatura() {
		infMetVacio.setTemperatura("23");;
		assertEquals(infMetVacio.getTemperatura(), "23");
	}
	
	@Test
	public void testGetSetSaturacionO2() {
		infMetVacio.setSaturacionO2(2);
		assertEquals(infMetVacio.getSaturacionO2(), 2);
	}
	
	@Test
	public void testToString() {
		String resultadoEsperado = "InfoMeteorologica [idInfo=" + infMetParam.getIdInfo() + ", fecha=" + infMetParam.getFecha() + ", hora=" + infMetParam.getHora() + ", presionAtm="
				+ infMetParam.getPresionAtm() + ", temperatura=" + infMetParam.getTemperatura() + ", saturacionO2=" + infMetParam.getSaturacionO2() + ", calidadAire="
				+ infMetParam.getCalidadAire() + ", nomEstMet=" + infMetParam.getNomEstMet() + "]";
		assertEquals(infMetParam.toString(), resultadoEsperado);
	}

}
