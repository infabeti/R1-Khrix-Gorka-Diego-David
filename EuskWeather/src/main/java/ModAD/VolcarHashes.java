package ModAD;

import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarHashes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static void volcarInformacion(ArrayList<Hashes> objetos) {
		
		for (int i = 0; i < objetos.size(); i++) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(objetos.get(i));
			session.getTransaction().commit();
			session.close();
			
		}
		HibernateUtil.shutdown();
	}
	
}
