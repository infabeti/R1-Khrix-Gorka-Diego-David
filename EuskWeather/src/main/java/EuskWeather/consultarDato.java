package EuskWeather;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.Entity;
import javax.swing.JTextArea;

public class consultarDato {
	
	

	public static Usuarios consultarUsuarios(String sql) {
		Usuarios users = new Usuarios();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String hql = "Select u from Usuarios u";
		Query query = session.createQuery(hql);
		
		List<Usuarios> results = query.list();
		for(int x= 0;x < results.size(); x++) {
			users = results.get(x);
		}
		return users;
		
	
	}

}
