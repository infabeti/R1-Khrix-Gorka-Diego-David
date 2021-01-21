package ModAD;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "informacionmeteorologica", uniqueConstraints = {@UniqueConstraint(columnNames = "idInfo"),@UniqueConstraint(columnNames = "fechaInfo"),
		@UniqueConstraint(columnNames = "presionAtm"),@UniqueConstraint(columnNames = "temperatura"),@UniqueConstraint(columnNames = "saturacionO2"),
		@UniqueConstraint(columnNames = "nomEstMet")})

public class InfoMeteorologica implements Serializable{
	
	@Id
	@Column(name = "idInfo", unique = true, nullable = false)
	private int idInfo;
	
	@Id
	@Column(name = "fechaInfo", unique = true, nullable = false)
	private Date fecha;
	
	@Id
	@Column(name = "presionAtm", unique = true, nullable = false)
	private double presionAtmos;
	
	@Id
	@Column(name = "temperatura", unique = true, nullable = false)
	private double temperaturaC;
	
	@Id
	@Column(name = "saturacionO2", unique = true, nullable = false)
	private int saturacionO2;
	
	@Id
	@Column(name = "nomEstMet", unique = true, nullable = false)
	private String nomEstMet;
	
	public InfoMeteorologica() {
		
	}
	
	public InfoMeteorologica(int idInfo, Date fecha, double presionAtmos, 
			double temperaturaC, int saturacionO2, String nomEstMet) {
		this.idInfo = idInfo;
		this.fecha = fecha;
		this.presionAtmos = presionAtmos;
		this.temperaturaC = temperaturaC;
		this.saturacionO2 = saturacionO2;
		this.nomEstMet = nomEstMet;
	}

	public String getNomEstMet() {
		return nomEstMet;
	}

	public void setNomEstMet(String nomEstMet) {
		this.nomEstMet = nomEstMet;
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
