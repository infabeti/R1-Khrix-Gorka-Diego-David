package EuskWeather;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ModAD.DescargarIndex;

public class DescargarIndexTest {

	private DescargarIndex di = new DescargarIndex();
	
	@Test
	public void testProcesarDatosAtmosfericos() throws IOException {
		di.procesarDatosAtmosfericos("./ficherosTest//index.xml");
	}

}
