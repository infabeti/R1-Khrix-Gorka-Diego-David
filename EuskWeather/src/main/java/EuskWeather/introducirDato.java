package EuskWeather;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		aa table = new aa();
		table.setDato1("TestEuskweather");
		table.setDato2("DatoEuskweather");
		table.setDato3("EuskweatherApp");
		
		session.save(table);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
