package EuskWeather;

import static org.junit.Assert.*;

import org.junit.Test;

import ModAD.HibernateUtil;

public class HibernateUtilTest {

	private HibernateUtil hu = new HibernateUtil();
	
	@Test
	public void testShutdown() {
		hu.shutdown();
	}

}
