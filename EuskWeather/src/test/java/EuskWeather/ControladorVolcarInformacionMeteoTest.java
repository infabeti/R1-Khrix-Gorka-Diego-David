package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorVolcarInformacionMeteo;
import ModAD.VolcarInfoMeteorologica;

public class ControladorVolcarInformacionMeteoTest {

	private VolcarInfoMeteorologica vim;
	private ControladorVolcarInformacionMeteo cvim;
	
	@Test
	public void testConstructor() {
		cvim = new ControladorVolcarInformacionMeteo(vim);
	}

}
