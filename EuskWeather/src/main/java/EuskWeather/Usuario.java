package EuskWeather;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.OptimisticLockType;

@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = "idUsuario"),@UniqueConstraint(columnNames = "nomApellidos"),
		@UniqueConstraint(columnNames = "direccion"),@UniqueConstraint(columnNames = "mail"),@UniqueConstraint(columnNames = "nickUsuario"),
		@UniqueConstraint(columnNames = "contrasenia")})

public class Usuario implements Serializable{
	@Id
	@Column(name = "idUsuario", unique = true, nullable = false)
	private int idUsuario;
	
	@Column(name = "nomApellidos", unique = false, nullable = false, length = 40)
	private String nomApellido;
	
	@Column(name = "direccion", unique = false, nullable = false, length = 100)
	private String direccion;
	
	@Column(name = "mail", unique = false, nullable = false, length = 40)
	private String mail;
	
	@Column(name = "nickUsuario", unique = false, nullable = false, length = 20)
	private String nickUsuario;
	
	@Column(name = "contrasenia", unique = false, nullable = false, length = 20)
	private String contrasenia;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario, String nomApellido, String direccion, String mail, 
			String nickUsuario, String contrasenia) {
		this.idUsuario = idUsuario;
		this.nomApellido = nomApellido;
		this.direccion = direccion;
		this.mail = mail;
		this.nickUsuario = nickUsuario;
		this.contrasenia = contrasenia;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomApellido() {
		return nomApellido;
	}

	public void setNomApellido(String nomApellido) {
		this.nomApellido = nomApellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNickUsuario() {
		return nickUsuario;
	}

	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
