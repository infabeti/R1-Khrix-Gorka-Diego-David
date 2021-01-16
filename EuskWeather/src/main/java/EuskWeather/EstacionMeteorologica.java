package EuskWeather;

import java.io.Serializable;

public class EstacionMeteorologica implements Serializable{

	private int idEstacion;
	private int idMuni;
	private String nombreEstacion;
	private double latidud;
	private double longitud;
	private String direccion;
	
	public EstacionMeteorologica() {
		
	}
	
	public EstacionMeteorologica(int idEstacion, int idMuni, String nombreEstacion, 
					double latitud, double longitud, String direccion) {
		this.idEstacion = idEstacion;
		this.idMuni = idMuni;
		this.nombreEstacion = nombreEstacion;
		this.latidud = latitud;
		this.longitud = longitud;
		this.direccion = direccion;
	}

	public int getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public int getIdMuni() {
		return idMuni;
	}

	public void setIdMuni(int idMuni) {
		this.idMuni = idMuni;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public double getLatidud() {
		return latidud;
	}

	public void setLatidud(double latidud) {
		this.latidud = latidud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
