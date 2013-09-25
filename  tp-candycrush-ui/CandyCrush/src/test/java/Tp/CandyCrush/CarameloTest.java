package Tp.CandyCrush;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CarameloTest extends TestCase {

	private Caramelo caramelo1;
	
	public void setUp(){
		caramelo1 = new Caramelo("Rojo");
	
	}
	
	public void testConstructor(){
		Assert.assertEquals(caramelo1.getColor(), "Rojo");
	}
	

}
