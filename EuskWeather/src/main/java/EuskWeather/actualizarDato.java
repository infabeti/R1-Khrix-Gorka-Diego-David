package EuskWeather;

import org.hibernate.Session;

public class actualizarDato {
	
	public static void main(String[] args) {
       
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Usuarios table = new Usuarios();
		table.setidUser(51);
		table.setnombreApellido("prueba");
		table.setDireccion("calle de prueba");
		table.setMail("mailActualizado");
		table.setNickUsuario("nick");
		table.setContrasenia("12");
		
		session.update(table);
		
		session.getTransaction().commit();
		session.close();

    }

}
