package EuskWeather;

import java.io.Serializable;

public class Municipio implements Serializable{
	
	private int idProv;
	private int idMunicipio;
	private String nombreMuni;
	private String alcaldeMuni;
	private String webMuni;
	
	public Municipio() {
		
	}
	
	public Municipio(int idProv, int idMunicipio, String nombreMuni, String alcaldeMuni,
			String webMuni) {
		this.idProv = idProv;
		this.idMunicipio = idMunicipio;
		this.nombreMuni = nombreMuni;
		this.alcaldeMuni = alcaldeMuni;
		this.webMuni = webMuni;
	}

	public int getIdProv() {
		return idProv;
	}

	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNombreMuni() {
		return nombreMuni;
	}

	public void setNombreMuni(String nombreMuni) {
		this.nombreMuni = nombreMuni;
	}

	public String getAlcaldeMuni() {
		return alcaldeMuni;
	}

	public void setAlcaldeMuni(String alcaldeMuni) {
		this.alcaldeMuni = alcaldeMuni;
	}

	public String getWebMuni() {
		return webMuni;
	}

	public void setWebMuni(String webMuni) {
		this.webMuni = webMuni;
	}

}
