package EuskWeather;

import java.io.File;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure(new File("src\\main\\java\\EuskWeather\\hibernate.cfg.xml")).buildSessionFactory();

		}catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);

		}
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
		
	}
	public static void shutdown() {
		getSessionFactory().close();
	}
	
}
