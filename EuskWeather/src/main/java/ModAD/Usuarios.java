package ModAD;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.OptimisticLockType;

@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = "idUser"),@UniqueConstraint(columnNames = "nombreApellido"),
		@UniqueConstraint(columnNames = "direccion"),@UniqueConstraint(columnNames = "mail"),@UniqueConstraint(columnNames = "nickUsuario"),
		@UniqueConstraint(columnNames = "contrasenia")})

public class Usuarios implements Serializable{
	@Id
	@Column(name = "idUser", unique = true, nullable = false)
	private int idUser;
	
	@Column(name = "nombreApellido", unique = false, nullable = false, length = 40)
	private String nombreApellido;
	
	@Column(name = "direccion", unique = false, nullable = false, length = 100)
	private String direccion;
	
	@Column(name = "mail", unique = false, nullable = false, length = 40)
	private String mail;
	
	@Column(name = "nickUsuario", unique = false, nullable = false, length = 20)
	private String nickUsuario;
	
	@Column(name = "contrasenia", unique = false, nullable = false, length = 20)
	private String contrasenia;
	
	public Usuarios() {
		
	}
	
	public Usuarios(int idUser, String nombreApellido, String direccion, String mail, 
			String nickUsuario, String contrasenia) {
		this.idUser = idUser;
		this.nombreApellido = nombreApellido;
		this.direccion = direccion;
		this.mail = mail;
		this.nickUsuario = nickUsuario;
		this.contrasenia = contrasenia;
	}

	public int getidUser() {
		return idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;
	}

	public String getnombreApellido() {
		return nombreApellido;
	}

	public void setnombreApellido(String nomApellido) {
		this.nombreApellido = nomApellido;
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
