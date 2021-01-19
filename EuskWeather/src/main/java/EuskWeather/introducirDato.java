package EuskWeather;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuarios table = new Usuarios();
		table.setIdUsuario(52);
		table.setNomApellido("prueba2");
		table.setDireccion("calle de prueba2");
		table.setMail("mail2");
		table.setNickUsuario("nick2");
		table.setContrasenia("123");
		
		session.save(table);
		
		session.getTransaction().commit();
		session.close();
	}
}
