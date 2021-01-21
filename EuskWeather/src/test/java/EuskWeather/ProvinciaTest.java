package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.Provincia;

public class ProvinciaTest {

	private Provincia pVacio = new Provincia();
	private Provincia pParam = new Provincia(1, "Bizkaia");
	
	@Test
	public void testConstructor() {
		assertEquals(pParam.getIdProv(), 1);
		assertEquals(pParam.getNombreProv(), "Bizkaia");
	}
	
	@Test
	public void testGetSetIdProv() {
		pVacio.setIdProv(2);
		assertEquals(pVacio.getIdProv(), 2);
	}
	
	@Test
	public void testGetSetNombreProv() {
		pVacio.setNombreProv("Gipuzkoa");
		assertEquals(pVacio.getNombreProv(), "Gipuzkoa");
	}

}
