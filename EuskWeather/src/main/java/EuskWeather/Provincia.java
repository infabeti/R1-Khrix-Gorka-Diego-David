package EuskWeather;

import java.io.Serializable;

public class Provincia implements Serializable{

	private int idProv;
	private String nombreProv;
	
	public Provincia() {
		
	}
	
	public Provincia(int idProv, String nombreProv) {
		this.idProv = idProv;
		this.nombreProv = nombreProv;
	}

	public int getIdProv() {
		return idProv;
	}

	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}

	public String getNombreProv() {
		return nombreProv;
	}

	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}
	
}
