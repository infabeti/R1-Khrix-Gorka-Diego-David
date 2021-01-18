package EuskWeather;

import org.hibernate.Session;

public class actualizarDato {
	
	public static void main(String[] args) {
       
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuario table = new Usuario();
		table.setIdUsuario(51);
		table.setNomApellido("prueba");
		table.setDireccion("calle de prueba");
		table.setMail("mailActualizado");
		table.setNickUsuario("nick");
		table.setContrasenia("12");
		
		session.update(table);
		
		session.getTransaction().commit();
		session.close();

    }

}
