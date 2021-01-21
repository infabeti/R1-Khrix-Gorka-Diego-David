package ModAD;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "estacionmeteorologica", uniqueConstraints = {@UniqueConstraint(columnNames = "idEstacion"),@UniqueConstraint(columnNames = "nombreEstacion"),
		@UniqueConstraint(columnNames = "latitud"),@UniqueConstraint(columnNames = "longitud"),@UniqueConstraint(columnNames = "direccion"),
		@UniqueConstraint(columnNames = "nomMunicipio")})

public class EstacionMeteorologica implements Serializable{

	@Id
	@Column(name = "idEstacion", unique = true, nullable = false)
	private int idEstacion;
	
	
	@Column(name = "nombreEstacion", unique = true, nullable = false)
	private String nombreEstacion;
	
	@Column(name = "latitud", unique = true, nullable = false)
	private double latidud;
	
	
	@Column(name = "longitud", unique = true, nullable = false)
	private double longitud;

	@Column(name = "direccion", unique = true, nullable = false)
	private String direccion;
	
	@Column(name = "nomMunicipio", unique = true, nullable = false)
	private String nomMunicipio;
	
	public EstacionMeteorologica() {
		
	}
	
	public EstacionMeteorologica(int idEstacion, String nombreEstacion, 
					double latitud, double longitud, String direccion, String nomMunicipio) {
		this.idEstacion = idEstacion;
		this.nombreEstacion = nombreEstacion;
		this.latidud = latitud;
		this.longitud = longitud;
		this.direccion = direccion;
		this.nomMunicipio = nomMunicipio;
	}

	public int getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(int idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNomMunicipio() {
		return nomMunicipio;
	}

	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public double getLatidud() {
		return latidud;
	}

	public void setLatidud(double latidud) {
		this.latidud = latidud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
