package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.DescargarPrincipales;

public class DescargarPrincipalesTest {

	private DescargarPrincipales dp = new DescargarPrincipales();
	
	@Test
	public void testDescargarFicheros() {
		dp.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/index.json", "./ficherosTest//index.json");
	}

}
