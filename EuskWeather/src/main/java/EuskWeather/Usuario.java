package EuskWeather;

import java.io.Serializable;

public class Usuario implements Serializable{

	private int idUsuario;
	private String nomApellido;
	private String direccion;
	private String mail;
	private String nickUsuario;
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
