package ContAD;

import java.io.IOException;

import ModAD.DescargarIndex;
import ModAD.convertirJSONXML;

public class ControladorDescargarIndex {
	
	private DescargarIndex descIndex;

	public ControladorDescargarIndex(DescargarIndex descIndex) {
		this.descIndex = descIndex;
	}
	public void descargarIndex() {
		try {
			String xml = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
			descIndex.procesarDatosAtmosfericos(xml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
