package ModAD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "municipios", uniqueConstraints = {@UniqueConstraint(columnNames = "idMuni"),@UniqueConstraint(columnNames = "nombreMuni"),
		@UniqueConstraint(columnNames = "alcalde"),@UniqueConstraint(columnNames = "webMunicipio"),@UniqueConstraint(columnNames = "idProvincia")})

public class Municipios implements Serializable{
	
	
	@Column(name = "idProvincia", unique = true, nullable = false)
	private int idProv;
	
	
	@Column(name = "idMuni", unique = true, nullable = false)
	private int idMunicipio;
	
	@Id
	@Column(name = "nombreMuni", unique = true, nullable = false)
	private String nombreMuni;
	
	
	@Column(name = "alcalde", unique = true, nullable = true)
	private String alcaldeMuni;
	
	
	@Column(name = "webMunicipio", unique = true, nullable = true)
	private String webMuni;
	
	public Municipios() {
		
	}
	
	public Municipios(int idProv, int idMunicipio, String nombreMuni, String alcaldeMuni,
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
