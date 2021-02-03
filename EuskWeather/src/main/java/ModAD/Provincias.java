package ModAD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "provincias", uniqueConstraints = {@UniqueConstraint(columnNames = "idProv"),@UniqueConstraint(columnNames = "nombreProv")})

public class Provincias implements Serializable{

	@Id
	@Column(name = "idProv", unique = true, nullable = false)
	private int idProv;
	

	@Column(name = "nombreProv", unique = true, nullable = false)
	private String nombreProv;
	
	public Provincias() {
		
	}
	
	public Provincias(int idProv, String nombreProv) {
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
