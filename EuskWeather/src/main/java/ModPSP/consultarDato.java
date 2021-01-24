package ModPSP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ModAD.HibernateUtil;
import ModAD.Municipios;
import ModAD.Usuarios;
import ModAD.Provincias;


import javax.persistence.Entity;
import javax.swing.JTextArea;

public class consultarDato {
	
	public static ArrayList<Usuarios> consultarUsuarios(String sql) {
		int x = 0;
		ArrayList<Usuarios> users = new ArrayList();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Iterator obj = session.createQuery(sql).iterate();
		while(obj.hasNext()) {
			Usuarios usuarios = (Usuarios) obj.next();
			users.add(usuarios);
		}
	
		return users;
		
	
	}
	
	public static ArrayList<Municipios> consultarMunicipios(String sql) {
		int x = 0;
		ArrayList<Municipios> munic = new ArrayList();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Iterator obj = session.createQuery(sql).iterate();
		while(obj.hasNext()) {
			Municipios municipios = (Municipios) obj.next();
			munic.add(municipios);
		}
	
		return munic;
		
	
	}
	
	public static ArrayList<Provincias> consultarProvincias(String sql) {
		int x = 0;
		ArrayList<Provincias> prov = new ArrayList();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Iterator obj = session.createQuery(sql).iterate();
		while(obj.hasNext()) {
			Provincias provincias = (Provincias) obj.next();
			prov.add(provincias);
		}
	
		return prov;
	}

}
