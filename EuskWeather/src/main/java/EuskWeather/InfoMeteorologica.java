package EuskWeather;

import java.io.Serializable;
import java.sql.Date;

public class InfoMeteorologica implements Serializable{

	private int idEstacionMeteo;
	private int idInfo;
	private Date fecha;
	private double presionAtmos;
	private double temperaturaC;
	private int saturacionO2;
	
	public InfoMeteorologica() {
		
	}
	
	public InfoMeteorologica(int idEstacionMeteo, int idInfo, Date fecha, double presionAtmos, 
			double temperaturaC, int saturacionO2) {
		this.idEstacionMeteo = idEstacionMeteo;
		this.idInfo = idInfo;
		this.fecha = fecha;
		this.presionAtmos = presionAtmos;
		this.temperaturaC = temperaturaC;
		this.saturacionO2 = saturacionO2;
	}

	public int getIdEstacionMeteo() {
		return idEstacionMeteo;
	}

	public void setIdEstacionMeteo(int idEstacionMeteo) {
		this.idEstacionMeteo = idEstacionMeteo;
	}

	public int getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(int idInfo) {
		this.idInfo = idInfo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPresionAtmos() {
		return presionAtmos;
	}

	public void setPresionAtmos(double presionAtmos) {
		this.presionAtmos = presionAtmos;
	}

	public double getTemperaturaC() {
		return temperaturaC;
	}

	public void setTemperaturaC(double temperaturaC) {
		this.temperaturaC = temperaturaC;
	}

	public int getSaturacionO2() {
		return saturacionO2;
	}

	public void setSaturacionO2(int saturacionO2) {
		this.saturacionO2 = saturacionO2;
	}
	
}
