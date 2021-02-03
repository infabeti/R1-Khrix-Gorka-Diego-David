package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.Provincias;

public class ProvinciaTest {

	private Provincias pVacio = new Provincias();
	private Provincias pParam = new Provincias(1, "Bizkaia");
	
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
