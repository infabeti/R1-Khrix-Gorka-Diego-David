package ContAD;

import ModAD.ModeloPrincipal;

public class ControladorPrincipal {
	public ControladorDescargarPrincipales contDP;
	public ControladorDescargarIndex contDI;
	public ControladorConvertirJSONXML contConvert;
	public ControladorVolcarMunicipios contVM;
	public ControladorVolcarEstaciones contVE;
	public ControladorVolcarEspaciosNaturales contVEN;
	public ControladorVolcarInformacionMeteo contVIM;
	
	public ControladorPrincipal(ModeloPrincipal modPrinc) {
		this.contDP = new ControladorDescargarPrincipales(modPrinc.descargarPrincip);
		this.contDI = new ControladorDescargarIndex(modPrinc.descargarIndex);
		this.contConvert = new ControladorConvertirJSONXML(modPrinc.convertirJson);
		this.contVM = new ControladorVolcarMunicipios(modPrinc.volcarMuni);
		this.contVE = new ControladorVolcarEstaciones(modPrinc.volcarEstaciones);
		this.contVEN = new ControladorVolcarEspaciosNaturales(modPrinc.volcarEspaciosNaturales);
		this.contVIM = new ControladorVolcarInformacionMeteo(modPrinc.volcarInfoMeteo);
	}
}
