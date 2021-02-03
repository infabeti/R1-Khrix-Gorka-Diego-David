package ContAD;

import java.io.IOException;

import ModAD.convertirJSONXML;

public class ControladorConvertirJSONXML {
	
	private convertirJSONXML convertirJson;

	public ControladorConvertirJSONXML(convertirJSONXML convertirJson) {
		this.convertirJson = convertirJson; 
	}
	
	public void convertirJsonXml() {
		try {
			convertirJson.principal();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
