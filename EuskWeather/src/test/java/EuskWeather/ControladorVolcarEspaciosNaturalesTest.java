package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorVolcarEspaciosNaturales;
import ModAD.VolcarEspaciosNaturales;

public class ControladorVolcarEspaciosNaturalesTest {

	private VolcarEspaciosNaturales ven;
	private ControladorVolcarEspaciosNaturales cve;
	
	@Test
	public void testConstructor() {
		cve = new ControladorVolcarEspaciosNaturales(ven);
	}

}
