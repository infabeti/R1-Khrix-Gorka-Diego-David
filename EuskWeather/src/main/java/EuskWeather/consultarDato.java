package EuskWeather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.Entity;
import javax.swing.JTextArea;

public class consultarDato {
	
	static ArrayList<Usuarios> users = new ArrayList();

	public static ArrayList<Usuarios> consultarUsuarios(String sql) {
		int x = 0;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Iterator obj = session.createQuery(sql).iterate();
		while(obj.hasNext()) {
			Usuarios usuarios = (Usuarios) obj.next();
			users.add(usuarios);
		}
	
		return users;
		
	
	}

}
