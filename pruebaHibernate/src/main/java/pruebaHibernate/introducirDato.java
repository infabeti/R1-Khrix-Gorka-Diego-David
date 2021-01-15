package pruebaHibernate;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		aa table = new aa();
		table.setDato1("TestDiego");
		table.setDato2("DatoDiego");
		table.setDato3("Perfect");
		
		session.save(table);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}
