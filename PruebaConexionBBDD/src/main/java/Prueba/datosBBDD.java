package Prueba;

import java.io.Serializable;
import java.util.Date;

public class datosBBDD implements Serializable{
	private int numero;
	private String string;
	private Date fecha;
	private boolean booleano;
	
	public datosBBDD() {
		super();
	}

	public datosBBDD(int numero, String string, Date fecha, boolean booleano) {
		super();
		this.numero = numero;
		this.string = string;
		this.fecha = fecha;
		this.booleano = booleano;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isBooleano() {
		return booleano;
	}

	public void setBooleano(boolean booleano) {
		this.booleano = booleano;
	}
	
	
	
	
	
}
