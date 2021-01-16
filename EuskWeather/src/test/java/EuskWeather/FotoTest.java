package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

public class FotoTest {

	private Foto fVacia = new Foto();
	private Foto fParam = new Foto(1, 2, 3);
	
	@Test
	public void testConstructor() {
		assertEquals(fParam.getIdFoto(), 1);
		assertEquals(fParam.getIdMunicipio(), 2);
		assertEquals(fParam.getIdUsuario(), 3);
	}
	
	@Test
	public void testGetSetIdFoto() {
		fVacia.setIdFoto(2);
		assertEquals(fVacia.getIdFoto(), 2);
	}
	
	@Test
	public void testGetSetIdMunicipio() {
		fVacia.setIdMunicipio(4);
		assertEquals(fVacia.getIdMunicipio(), 4);
	}
	
	@Test
	public void testGetSetIdUsuario() {
		fVacia.setIdUsuario(6);
		assertEquals(fVacia.getIdUsuario(), 6);
	}

}
