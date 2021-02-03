package ContAD;

import java.util.ArrayList;

import ModAD.EspacioNatural;
import ModAD.VolcarEspaciosNaturales;
import ModAD.convertirJSONXML;

public class ControladorVolcarEspaciosNaturales {
	private VolcarEspaciosNaturales volcarEspaciosNaturales;

	public ControladorVolcarEspaciosNaturales(VolcarEspaciosNaturales volcarEspaciosNaturales) {
		// TODO Auto-generated constructor stub
		this.volcarEspaciosNaturales = volcarEspaciosNaturales;
	}
	public void volcarEspNatur() {
		String xmlEspaciosNaturales = convertirJSONXML.leerArchivo("./ficherosXML//espacios-naturales.xml", "utf-8");
    	ArrayList<EspacioNatural> espaciosNaturales = VolcarEspaciosNaturales.lecturaDatos(xmlEspaciosNaturales);
    	VolcarEspaciosNaturales.volcarInformacion(espaciosNaturales);
	}
}
