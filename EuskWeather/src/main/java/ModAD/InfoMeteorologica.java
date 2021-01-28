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
		@UniqueConstraint(columnNames = "hora"), @UniqueConstraint(columnNames = "presionAtm"),@UniqueConstraint(columnNames = "temperatura"),
		@UniqueConstraint(columnNames = "saturacionO2"), @UniqueConstraint(columnNames = "calidadAire"), @UniqueConstraint(columnNames = "nomEstMet")})

public class InfoMeteorologica implements Serializable{

	@Id
	@Column(name = "idInfo", unique = true, nullable = false)
	private int idInfo;
	
	@Column(name = "fechaInfo", unique = true, nullable = true)
	private String fecha;
	
	@Column(name = "hora", unique = true, nullable = true)
	private String hora;
	
	@Column(name = "presionAtm", unique = true, nullable = true)
	private String presionAtm;
	
	@Column(name = "temperatura", unique = true, nullable = true)
	private String temperatura;
	
	@Column(name = "saturacionO2", unique = true, nullable = true)
	private int saturacionO2;
	
	@Column(name = "calidadAire", unique = true, nullable = true)
	private String calidadAire;
	
	@Column(name = "nomEstMet", unique = true, nullable = false)
	private String nomEstMet;
	
	public InfoMeteorologica() {
		
	}
	
	public InfoMeteorologica(int idInfo, String fecha, String hora, String presionAtm, String temperatura,
			int saturacionO2, String calidadAire, String nomEstMet) {
		this.idInfo = idInfo;
		this.fecha = fecha;
		this.hora = hora;
		this.presionAtm = presionAtm;
		this.temperatura = temperatura;
		this.saturacionO2 = saturacionO2;
		this.calidadAire = calidadAire;
		this.nomEstMet = nomEstMet;
	}
	
	@Override
	public String toString() {
		return "InfoMeteorologica [idInfo=" + idInfo + ", fecha=" + fecha + ", hora=" + hora + ", presionAtm="
				+ presionAtm + ", temperatura=" + temperatura + ", saturacionO2=" + saturacionO2 + ", calidadAire="
				+ calidadAire + ", nomEstMet=" + nomEstMet + "]";
	}

	public int getIdInfo() {
		return idInfo;
	}

	public void setIdInfo(int idInfo) {
		this.idInfo = idInfo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPresionAtm() {
		return presionAtm;
	}

	public void setPresionAtm(String presionAtm) {
		this.presionAtm = presionAtm;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public int getSaturacionO2() {
		return saturacionO2;
	}

	public void setSaturacionO2(int saturacionO2) {
		this.saturacionO2 = saturacionO2;
	}

	public String getCalidadAire() {
		return calidadAire;
	}

	public void setCalidadAire(String calidadAire) {
		this.calidadAire = calidadAire;
	}

	public String getNomEstMet() {
		return nomEstMet;
	}

	public void setNomEstMet(String nomEstMet) {
		this.nomEstMet = nomEstMet;
	}
	
}
