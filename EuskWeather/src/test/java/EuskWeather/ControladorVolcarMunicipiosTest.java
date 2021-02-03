package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorVolcarMunicipios;
import ModAD.VolcarMunicipios;

public class ControladorVolcarMunicipiosTest {

	private VolcarMunicipios vm;
	private ControladorVolcarMunicipios cvm;
	
	@Test
	public void testConstructor() {
		cvm = new ControladorVolcarMunicipios(vm);
	}
	
//	@Test
//	public void testVolcarMunicipios() {
//		cvm = new ControladorVolcarMunicipios(vm);
//		cvm.volcarMunicipos();
//	}

}
