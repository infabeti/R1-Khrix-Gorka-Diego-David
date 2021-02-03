package EuskWeatherApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import ContAD.ControladorPrincipal;
import ModAD.DescargarIndex;
import ModAD.DescargarPrincipales;
import ModAD.EspacioNatural;
import ModAD.EstacionMeteorologica;
import ModAD.ModeloPrincipal;
import ModAD.Municipios;
import ModAD.VolcarEspaciosNaturales;
import ModAD.VolcarEstaciones;
import ModAD.VolcarInfoMeteorologica;
import ModAD.VolcarMunicipios;
import ModAD.convertirJSONXML;
import VistaAD.vistaActualizarBBDD;

public class Ejecutable {

	public static void ejecutable() throws IOException {
		// TODO Auto-generated method stub
		//DESCARGAR FICHEROS PRINCIPALES
		
		ModeloPrincipal modeloPrinc = new ModeloPrincipal();
		
		ControladorPrincipal contP = new ControladorPrincipal(modeloPrinc);
		
		vistaActualizarBBDD frame = new vistaActualizarBBDD(contP);
		frame.setVisible(true);
		
		
    	
		
		
	}

}
