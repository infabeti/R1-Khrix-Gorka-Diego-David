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
		
		Iterator obj = session.createQuery("Select u from Usuarios u").iterate();
		while(obj.hasNext()) {
			Usuarios usuarios = (Usuarios) obj.next();
			users.add(usuarios);
		}
		
//		String hql = "Select u from Usuarios u";
//		Query query = session.createQuery(hql);
//		
//		List<Usuarios> results = query.list();
//		for(int x= 0;x < results.size(); x++) {
//			usuario = results.get(x);
//			users.add(usuario);
//		}
		return users;
		
	
	}

}
