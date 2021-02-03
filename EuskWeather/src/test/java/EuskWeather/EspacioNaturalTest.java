package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.EspacioNatural;

public class EspacioNaturalTest {

	private EspacioNatural epVacio = new EspacioNatural();
	private EspacioNatural epParam = new EspacioNatural(1, "La Arboleda", "Convertido en espacio de ocio", "Pantanos", "Getxo");
	
	@Test
	public void test() {
		assertEquals(epParam.getIdEspacioNat(), 1);
		assertEquals(epParam.getNombreEspacioNat(), "La Arboleda");
		assertEquals(epParam.getDescripcion(), "Convertido en espacio de ocio");
		assertEquals(epParam.getTipo(), "Pantanos");
	}
	
	@Test
	public void testGetSetIdEspacioNat() {
		epVacio.setIdEspacioNat(2);
		assertEquals(epVacio.getIdEspacioNat(), 2);
	}
	
	@Test
	public void testGetSetNombreEspacioNat() {
		epVacio.setNombreEspacioNat("Santiago de Deba");
		assertEquals(epVacio.getNombreEspacioNat(), "Santiago de Deba");
	}
	
	@Test
	public void testGetSetDescripcion() {
		epVacio.setDescripcion("se halla al oeste del litoral guipuzcoano");
		assertEquals(epVacio.getDescripcion(), "se halla al oeste del litoral guipuzcoano");
	}
	
	@Test
	public void testGetSetTipo() {
		epVacio.setTipo("Playas");
		assertEquals(epVacio.getTipo(), "Playas");
	}

}
