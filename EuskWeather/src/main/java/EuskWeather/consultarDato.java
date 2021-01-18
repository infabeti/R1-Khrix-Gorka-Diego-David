package EuskWeather;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.Entity;
import javax.swing.JTextArea;

public class consultarDato {

	public static String consultarUsuarios(String sql) {
		List<Usuario[]> result = null;
		String resultado = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		result = session.createSQLQuery(sql).list();

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

		return resultado;
	}

}
