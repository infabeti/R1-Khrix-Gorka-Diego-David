package ContAD;

import java.io.File;

import ModAD.DescargarPrincipales;

public class ControladorDescargarPrincipales {

	private DescargarPrincipales descPrinc;
	
	public ControladorDescargarPrincipales(DescargarPrincipales descPrinc) {
		this.descPrinc = descPrinc;
	}

	public void descPrinciples() {
		String nomFichero[] = {"index", "municipios", "estaciones", "espacios-naturales"};
		for(int i = 0; i < nomFichero.length; i++) {
			File f = new File("./archJSON//" + nomFichero[i] + ".json");
			if(f.exists()) {
				descPrinc.verificarInformacion(nomFichero[i]);
			} else {
				if(nomFichero[i].equals("index") || nomFichero[i].equals("estaciones")) {
					descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/" + nomFichero[i] + ".json", "./archJSON//" + nomFichero[i] + ".json");
				} else if(nomFichero[i].equals("espacios-naturales")) {
					descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/" + nomFichero[i] + ".json", "./archJSON//" + nomFichero[i] + ".json");
				} else if(nomFichero[i].equals("municipios")) {
					descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//" + nomFichero[i] + ".json");
				}
			}
		}
//		descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/index.json", "./archJSON//index.json");
//		descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/estaciones.json", "./archJSON//estaciones.json");
//		descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/espacios-naturales.json", "./archJSON//espacios-naturales.json");
//		descPrinc.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//municipios.json");
	}
	
}
