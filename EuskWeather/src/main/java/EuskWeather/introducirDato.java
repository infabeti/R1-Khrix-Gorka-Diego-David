package EuskWeather;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuario table = new Usuario();
		table.setIdUsuario(51);
		table.setNomApellido("prueba");
		table.setDireccion("calle de prueba");
		table.setMail("mail");
		table.setNickUsuario("nick");
		table.setContrasenia("12");
		
		session.save(table);
		
		session.getTransaction().commit();
		session.close();
	}
}
