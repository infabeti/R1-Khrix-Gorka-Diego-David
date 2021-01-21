package EuskWeather;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ModAD.InfoMeteorologica;

public class InfoMeteorologicaTest {

	private InfoMeteorologica infMetVacio = new InfoMeteorologica();
	private InfoMeteorologica infMetParam = new InfoMeteorologica(1, new Date(2020-03-12), 
			2.4, 7.2, 4, "Abadino");
	
	@Test
	public void testConstructor() {
		assertEquals(infMetParam.getIdInfo(), 1);
		assertEquals(infMetParam.getFecha(), new Date(2020-03-12));
		assertEquals(infMetParam.getPresionAtmos(), 2.4, 1);
		assertEquals(infMetParam.getTemperaturaC(), 7.2, 1);
		assertEquals(infMetParam.getSaturacionO2(), 4);
		assertEquals(infMetParam.getNomEstMet(), "Abadino");
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
		infMetVacio.setFecha(new Date(2020-11-23));
		assertEquals(infMetVacio.getFecha(), new Date(2020-11-23));
	}
	
	@Test
	public void testGetSetPresionAtmos() {
		infMetVacio.setPresionAtmos(5.2);
		assertEquals(infMetVacio.getPresionAtmos(), 5.2, 1);
	}
	
	@Test
	public void testGetSetTemperaturaC() {
		infMetVacio.setTemperaturaC(4.3);
		assertEquals(infMetVacio.getTemperaturaC(), 4.3, 1);
	}
	
	@Test
	public void testGetSetSaturacionO2() {
		infMetVacio.setSaturacionO2(2);
		assertEquals(infMetVacio.getSaturacionO2(), 2);
	}

}
