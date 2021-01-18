package EuskWeather;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.Entity;

public class consultarDato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Usuario[]> result = null;
		String resultado = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		result = session.createSQLQuery("select * from Usuarios").list();

		try {
		for (Object[] row : result) {
			resultado +=  "\n";
			for (Object col : row) {
				resultado += col + " ";
			}
		}
		resultado +=  "\n";
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		session.close();

		System.out.println(resultado);
	}

}
