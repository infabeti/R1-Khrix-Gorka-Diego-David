package pruebaHibernate;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		aa table = new aa();
		table.setDato1("Test2");
		table.setDato2("Introducir Dato2");
		table.setDato3("Correcto");
		
		session.save(table);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
