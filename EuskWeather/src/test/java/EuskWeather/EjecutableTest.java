package EuskWeather;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import EuskWeatherApp.Ejecutable;

public class EjecutableTest {

	Ejecutable ej = new Ejecutable();
	
	@Test
	public void testEjecutable() {
		try {
			ej.ejecutable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
