package EuskWeather;

import org.hibernate.Session;

public class introducirDato {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuarios table = new Usuarios();
		table.setidUser(54);
		table.setnombreApellido("prueba3");
		table.setDireccion("calle de prueba3");
		table.setMail("mail3");
		table.setNickUsuario("nick3");
		table.setContrasenia("123");
		
		session.save(table);
		
		session.getTransaction().commit();
		session.close();
	}
}
