package Tp.CandyCrush;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ExplosionTest extends TestCase {

	private Explosion explosion = new Explosion(5, "Rojo");
	public void setUp(){
		
	}
	
	public void testConstructor(){
		Assert.assertEquals(explosion.getColor(), "Rojo");
		Assert.assertEquals(explosion.getCantidad(), 5);
	}
	
	
}
