package EuskWeather;

import java.io.Serializable;

public class EspacioNatural implements Serializable{

	private int idEspacioNat;
	private String nombreEspacioNat;
	private String descripcion;
	private String tipo;
	
	public EspacioNatural() {
		
	}
	
	public EspacioNatural(int idEspacioNat, String nombreEspacioNat, String descripcion, 
			String tipo) {
		this.idEspacioNat = idEspacioNat;
		this.nombreEspacioNat = nombreEspacioNat;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public int getIdEspacioNat() {
		return idEspacioNat;
	}

	public void setIdEspacioNat(int idEspacioNat) {
		this.idEspacioNat = idEspacioNat;
	}

	public String getNombreEspacioNat() {
		return nombreEspacioNat;
	}

	public void setNombreEspacioNat(String nombreEspacioNat) {
		this.nombreEspacioNat = nombreEspacioNat;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
