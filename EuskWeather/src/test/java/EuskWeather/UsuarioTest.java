package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.Usuarios;

public class UsuarioTest {

	private Usuarios usuVacio = new Usuarios();
	private Usuarios usuParam = new Usuarios(1, "Diego Villalon", "Zabalbide Kalea", "diego@elorrieta.com", 
								"diegovjelorrieta", "1234qwerty");
	
	@Test
	public void testConstructor() {
		assertEquals(usuParam.getidUser(), 1);
		assertEquals(usuParam.getnombreApellido(), "Diego Villalon");
		assertEquals(usuParam.getDireccion(), "Zabalbide Kalea");
		assertEquals(usuParam.getMail(), "diego@elorrieta.com");
		assertEquals(usuParam.getNickUsuario(), "diegovjelorrieta");
		assertEquals(usuParam.getContrasenia(), "1234qwerty");
	}
	
	@Test
	public void testGetSetIdUsuario() {
		usuVacio.setidUser(1);
		assertEquals(usuVacio.getidUser(), 1);
	}
	
	@Test
	public void testGetSetNomApellido() {
		usuVacio.setnombreApellido("Gorka Carnero");
		assertEquals(usuVacio.getnombreApellido(), "Gorka Carnero");
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
