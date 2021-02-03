package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorDescargarPrincipales;
import ModAD.DescargarPrincipales;

public class ControladorDescargarPrincipalesTest {

	private DescargarPrincipales dp;
	private ControladorDescargarPrincipales cdp;
	
	@Test
	public void testConstructor() {
		cdp = new ControladorDescargarPrincipales(dp);
	}
	
	@Test
	public void testDescPrincipales() {
		cdp = new ControladorDescargarPrincipales(dp);
		cdp.descPrinciples();
	}

}
