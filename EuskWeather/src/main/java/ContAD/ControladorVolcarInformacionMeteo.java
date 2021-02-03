package ContAD;

import java.util.ArrayList;

import ModAD.InformacionMeteorologica;
import ModAD.VolcarInfoMeteorologica;

public class ControladorVolcarInformacionMeteo {
	private VolcarInfoMeteorologica volcarInfo;
		
	public ControladorVolcarInformacionMeteo(VolcarInfoMeteorologica volcarInfo) {
		this.volcarInfo = volcarInfo;
	}

	public void volcarInfor() {
		ArrayList<InformacionMeteorologica> listadoInfoMeteorologica = new ArrayList<InformacionMeteorologica>();
		listadoInfoMeteorologica = volcarInfo.lecturaDatos();
		volcarInfo.volcarInformacion(listadoInfoMeteorologica);
	}

}
