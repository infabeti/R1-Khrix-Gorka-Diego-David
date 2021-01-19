package EuskWeather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
			Municipios usuarios = (Municipios) obj.next();
			munic.add(usuarios);
		}
	
		return munic;
		
	
	}

}
