package EuskWeather;

import java.io.Serializable;

public class Foto implements Serializable{

	private int idFoto;
	private int idMunicipio;
	private int idUsuario;
	
	public Foto() {
		
	}
	
	public Foto(int idFoto, int idMunicipio, int idUsuario) {
		this.idFoto = idFoto;
		this.idMunicipio = idMunicipio;
		this.idUsuario = idUsuario;
	}

	public int getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
