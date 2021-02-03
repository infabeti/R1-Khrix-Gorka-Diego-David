package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ContAD.ControladorConvertirJSONXML;
import ModAD.convertirJSONXML;

public class ControladorConvertirJSONXMLTest {

	private convertirJSONXML convertirJson;
	private ControladorConvertirJSONXML contConv;
	
	@Test
	public void testConstructor() {
		contConv = new ControladorConvertirJSONXML(convertirJson);
	}
	
	@Test
	public void testConvertirJsonXml() {
		contConv = new ControladorConvertirJSONXML(convertirJson);
		contConv.convertirJsonXml();
	}

}
