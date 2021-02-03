package ContAD;

import java.util.ArrayList;

import ModAD.Municipios;
import ModAD.VolcarMunicipios;
import ModAD.convertirJSONXML;

public class ControladorVolcarMunicipios {
	
	private VolcarMunicipios volcarMuni;

	public ControladorVolcarMunicipios(VolcarMunicipios volcarMuni) {
		// TODO Auto-generated constructor stub
		this.volcarMuni = volcarMuni;
	}
	public void volcarMunicipos() {
		String xmlMunicipios = convertirJSONXML.leerArchivo("./ficherosXML//municipios.xml", "utf-8");
    	ArrayList<Municipios> municipios = volcarMuni.lecturaDatos(xmlMunicipios);
    	volcarMuni.volcarInformacion(municipios);
	}

}
