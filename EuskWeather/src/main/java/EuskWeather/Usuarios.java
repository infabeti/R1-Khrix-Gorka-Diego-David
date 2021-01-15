package EuskWeather;

public class Usuarios {

	private int idUsu;
	private String nomApellidos;
	private String direccion;
	private String mail;
	private String nomUsu;
	private String pass;
	
	public Usuarios(int idUsu, String nomApellidos, String direccion, String mail, String nomUsu, String pass) {
		this.idUsu = idUsu;
		this.nomApellidos = nomApellidos;
		this.direccion = direccion;
		this.mail = mail;
		this.nomUsu = nomUsu;
		this.pass = pass;
	}

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getNomApellidos() {
		return nomApellidos;
	}

	public void setNomApellidos(String nomApellidos) {
		this.nomApellidos = nomApellidos;
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

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
