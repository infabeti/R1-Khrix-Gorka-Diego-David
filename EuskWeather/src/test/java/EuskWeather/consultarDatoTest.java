package EuskWeather;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ModAD.EspaciosNaturales;
import ModAD.EstacionMeteorologica;
import ModAD.InformacionMeteorologica;
import ModAD.Municipios;
import ModAD.Provincias;
import ModAD.Usuarios;
import ModPSP.consultarDato;

public class consultarDatoTest {

	private consultarDato cd = new consultarDato();
	
	@Test
	public void testConsultarUsuarios() {
		ArrayList<Usuarios> resultado = cd.consultarUsuarios("select u from Usuarios u");
		//ArrayList<Usuarios> resultadoEsperado = cd.consultarUsuarios("select u from Usuarios u");
	}
	
	@Test
	public void testConsultarMunicipios() {
		ArrayList<Municipios> resultado = cd.consultarMunicipios("select m from Municipios m where m.idProv = 48");
	}
	
	@Test
	public void testConsultarProvincias() {
		ArrayList<Provincias> resultado = cd.consultarProvincias("select p from Provincias p");
	}
	
	@Test
	public void testConsultarEstaciones() {
		ArrayList<EstacionMeteorologica> resultado = cd.consultarEstaciones("select e from EstacionMeteorologica e where e.nomMunicipio = 'Abadiño'");
	}
	
	@Test
	public void testConsultarInfoMeteo() {
		ArrayList<InformacionMeteorologica> resultado = cd.consultarInfoMeteo("select i from InformacionMeteorologica i where i.nomEstMet = 'URKIOLA'");
	}
	
	@Test
	public void testConsultarEspacio() {
		ArrayList<EspaciosNaturales> resultado = cd.consultarEspacio("select esp from EspaciosNaturales esp where esp.nomMunicipio='Getxo'");
	}

}
