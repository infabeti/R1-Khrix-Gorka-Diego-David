package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.Foto;

public class FotoTest {

	private Foto fVacia = new Foto();
	private Foto fParam = new Foto(1, "Bilbao", 3);
	
	@Test
	public void testConstructor() {
		assertEquals(fParam.getIdFoto(), 1);
		assertEquals(fParam.getNombreMunicipio(), "Bilbao");
		assertEquals(fParam.getIdUsuario(), 3);
	}
	
	@Test
	public void testGetSetIdFoto() {
		fVacia.setIdFoto(2);
		assertEquals(fVacia.getIdFoto(), 2);
	}
	
	@Test
	public void testGetSetNombreMunicipio() {
		fVacia.setNombreMunicipio("Barakaldo");
		assertEquals(fVacia.getNombreMunicipio(), "Barakaldo");
	}
	
	@Test
	public void testGetSetIdUsuario() {
		fVacia.setIdUsuario(6);
		assertEquals(fVacia.getIdUsuario(), 6);
	}

}
