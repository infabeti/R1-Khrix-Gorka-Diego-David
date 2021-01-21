package ModPSP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ModAD.HibernateUtil;
import ModAD.Municipios;
import ModAD.Usuarios;

import javax.persistence.Entity;
import javax.swing.JTextArea;

public class consultarDato {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consultarMunicipios();
	}
	

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
	
	public static ArrayList<Municipios> consultarMunicipios() {
		int x = 0;
		ArrayList<Municipios> munic = new ArrayList();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//Iterator obj = session.createQuery("select m from Provincia p left join p.idProv m where p.idProv = m.idProv").iterate();
		Iterator obj = session.createQuery("select m from Municipios as m left join m.idProv p where m.idProv = p.idProv").iterate();
		while(obj.hasNext()) {
			Municipios usuarios = (Municipios) obj.next();
			munic.add(usuarios);
		}
	
		return munic;
		
	
	}

}
