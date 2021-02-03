package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorDescargarIndex;
import ModAD.DescargarIndex;

public class ControladorDescargarIndexTest {

	private DescargarIndex di;
	private ControladorDescargarIndex cdi;
	
	@Test
	public void testConstructor() {
		cdi = new ControladorDescargarIndex(di);
	}
	
//	@Test
//	public void testDescargarIndex() {
//		cdi = new ControladorDescargarIndex(di);
//		cdi.descargarIndex();
//	}

}
