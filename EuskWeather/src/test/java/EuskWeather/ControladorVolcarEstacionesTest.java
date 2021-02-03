package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorVolcarEstaciones;
import ModAD.VolcarEstaciones;

public class ControladorVolcarEstacionesTest {

	private VolcarEstaciones ve;
	private ControladorVolcarEstaciones cve;
	
	@Test
	public void testConstructor() {
		cve = new ControladorVolcarEstaciones(ve);
	}

}
