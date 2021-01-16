package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	private Usuario usuVacio = new Usuario();
	private Usuario usuParam = new Usuario(1, "Diego Villalon", "Zabalbide Kalea", "diego@elorrieta.com", 
								"diegovjelorrieta", "1234qwerty");
	
	@Test
	public void testConstructor() {
		assertEquals(usuParam.getIdUsuario(), 1);
		assertEquals(usuParam.getNomApellido(), "Diego Villalon");
		assertEquals(usuParam.getDireccion(), "Zabalbide Kalea");
		assertEquals(usuParam.getMail(), "diego@elorrieta.com");
		assertEquals(usuParam.getNickUsuario(), "diegovjelorrieta");
		assertEquals(usuParam.getContrasenia(), "1234qwerty");
	}
	
	@Test
	public void testGetSetIdUsuario() {
		usuVacio.setIdUsuario(1);
		assertEquals(usuVacio.getIdUsuario(), 1);
	}
	
	@Test
	public void testGetSetNomApellido() {
		usuVacio.setNomApellido("Gorka Carnero");
		assertEquals(usuVacio.getNomApellido(), "Gorka Carnero");
	}
	
	@Test
	public void testGetSetDireccion() {
		usuVacio.setDireccion("Santurtzi");
		assertEquals(usuVacio.getDireccion(), "Santurtzi");
	}
	
	@Test
	public void testGetSetMail() {
		usuVacio.setMail("gorka@elorrieta.com");
		assertEquals(usuVacio.getMail(), "gorka@elorrieta.com");
	}
	
	@Test
	public void testGetSetNickUsuario() {
		usuVacio.setNickUsuario("gorkacElorrieta");
		assertEquals(usuVacio.getNickUsuario(), "gorkacElorrieta");
	}
	
	@Test
	public void testGetSetContrasenia() {
		usuVacio.setContrasenia("9876poiuy");
		assertEquals(usuVacio.getContrasenia(), "9876poiuy");
	}

}
