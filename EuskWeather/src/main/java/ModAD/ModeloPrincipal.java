package ModAD;

public class ModeloPrincipal {
	public DescargarPrincipales descargarPrincip;
	public DescargarIndex descargarIndex;
	public convertirJSONXML convertirJson;
	public VolcarMunicipios volcarMuni;
	public VolcarEstaciones volcarEstaciones;
	public VolcarEspaciosNaturales volcarEspaciosNaturales;
	public VolcarInfoMeteorologica volcarInfoMeteo;
	
	public ModeloPrincipal() {
		this.descargarPrincip = new DescargarPrincipales();
		this.descargarIndex = new DescargarIndex();
		this.convertirJson = new convertirJSONXML();
		this.volcarMuni = new VolcarMunicipios();
		this.volcarEstaciones = new VolcarEstaciones();
		this.volcarEspaciosNaturales = new VolcarEspaciosNaturales();
		this.volcarInfoMeteo = new VolcarInfoMeteorologica();
	}

	
}
