package ContAD;

import java.util.ArrayList;

import ModAD.EstacionMeteorologica;
import ModAD.Municipios;
import ModAD.VolcarEstaciones;
import ModAD.convertirJSONXML;

public class ControladorVolcarEstaciones {
	
	private VolcarEstaciones volcarEstaciones;

	public ControladorVolcarEstaciones(VolcarEstaciones volcarEstaciones) {
		// TODO Auto-generated constructor stub
		this.volcarEstaciones = volcarEstaciones;
	}
	public void volcarEstaciones() {
		String xmlEstaciones = convertirJSONXML.leerArchivo("./ficherosXML//estaciones.xml", "utf-8");
    	ArrayList<EstacionMeteorologica> estaciones = volcarEstaciones.lecturaDatos(xmlEstaciones);
    	volcarEstaciones.volcarInformacion(estaciones);
	}

}

