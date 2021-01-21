package ModAD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "fotos", uniqueConstraints = {@UniqueConstraint(columnNames = "idFoto"),@UniqueConstraint(columnNames = "nombreMunicipio"),
		@UniqueConstraint(columnNames = "idUsuario")})

public class Foto implements Serializable{

	@Id
	@Column(name = "idFoto", unique = true, nullable = false)
	private int idFoto;
	
	@Id
	@Column(name = "nombreMunicipio", unique = true, nullable = false)
	private String nombreMunicipio;
	
	@Id
	@Column(name = "idUsuario", unique = true, nullable = false)
	private int idUsuario;
	
	public Foto() {
		
	}
	
	public Foto(int idFoto, String nombreMunicipio, int idUsuario) {
		this.idFoto = idFoto;
		this.nombreMunicipio = nombreMunicipio;
		this.idUsuario = idUsuario;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
