package ModAD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "espaciosnaturales", uniqueConstraints = {@UniqueConstraint(columnNames = "idEspNat"),@UniqueConstraint(columnNames = "nombreEspNat"),
		@UniqueConstraint(columnNames = "descripcion"),@UniqueConstraint(columnNames = "tipoEspNat")})

public class EspacioNatural implements Serializable{

	@Id
	@Column(name = "idEspNat", unique = true, nullable = false)
	private int idEspacioNat;
	
	@Id
	@Column(name = "nombreEspNat", unique = true, nullable = false)
	private String nombreEspacioNat;
	
	@Id
	@Column(name = "descripcion", unique = true, nullable = false)
	private String descripcion;
	
	@Id
	@Column(name = "tipoEspNat", unique = true, nullable = false)
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
