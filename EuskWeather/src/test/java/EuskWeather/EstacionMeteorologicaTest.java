package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstacionMeteorologicaTest {

	private EstacionMeteorologica emVacio = new EstacionMeteorologica();
	private EstacionMeteorologica emParam = new EstacionMeteorologica(1, 1, "EstBilbao", 2.52, -3.1, "zabalbide kalea");

	@Test
	public void testConstructor() {
		assertEquals(emParam.getIdEstacion(), 1);
		assertEquals(emParam.getIdMuni(), 1);
		assertEquals(emParam.getNombreEstacion(), "EstBilbao");
		assertEquals(emParam.getLatidud(), 2.52, 1);
		assertEquals(emParam.getLongitud(), -3.1, 1);
		assertEquals(emParam.getDireccion(), "zabalbide kalea");
	}
	
	@Test
	public void testGetSetIdEstacion() {
		emVacio.setIdEstacion(1);
		assertEquals(emVacio.getIdEstacion(), 1);
	}
	
	@Test
	public void testGetSetIdMuni() {
		emVacio.setIdMuni(1);
		assertEquals(emVacio.getIdMuni(), 1);
	}
	
	@Test
	public void testGetSetNombreEstacion() {
		emVacio.setNombreEstacion("EstacionMet");
		assertEquals(emVacio.getNombreEstacion(), "EstacionMet");
	}
	
	@Test
	public void testGetSetLatitud() {
		emVacio.setLatidud(2.52);
		assertEquals(emVacio.getLatidud(), 2.52, 1);
	}
	
	@Test
	public void testGetSetLongitud() {
		emVacio.setLongitud(-4.2);
		assertEquals(emVacio.getLongitud(), -4.2, 1);
	}
	
	@Test
	public void testGetSetDireccion() {
		emVacio.setDireccion("direccion estacion");
		assertEquals(emVacio.getDireccion(), "direccion estacion");
	}
}
