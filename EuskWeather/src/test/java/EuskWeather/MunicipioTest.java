package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.Municipios;

public class MunicipioTest {

	private Municipios mVacio = new Municipios();
	private Municipios mParam = new Municipios(1, 2, "Bilbao", "Aburto", "www.bilbao.eus");

	@Test
	public void testConstructor() {
		assertEquals(mParam.getIdProv(), 1);
		assertEquals(mParam.getIdMunicipio(), 2);
		assertEquals(mParam.getNombreMuni(), "Bilbao");
		assertEquals(mParam.getAlcaldeMuni(), "Aburto");
		assertEquals(mParam.getWebMuni(), "www.bilbao.eus");
	}
	
	@Test
	public void testGetSetIdProv() {
		mVacio.setIdProv(1);
		assertEquals(mVacio.getIdProv(), 1);
	}
	
	@Test
	public void testGetSetIdMuni() {
		mVacio.setIdMunicipio(1);
		assertEquals(mVacio.getIdMunicipio(), 1);
	}
	
	@Test
	public void testGetSetNombreMuni() {
		mVacio.setNombreMuni("Basauri");
		assertEquals(mVacio.getNombreMuni(), "Basauri");
	}
	
	@Test
	public void testGetSetAlcaldeMuni() {
		mVacio.setAlcaldeMuni("Iragorri");
		assertEquals(mVacio.getAlcaldeMuni(), "Iragorri");
	}
	
	@Test
	public void testGetSetWebMuni() {
		mVacio.setWebMuni("www.basauri.net");
		assertEquals(mVacio.getWebMuni(), "www.basauri.net");
	}

}
