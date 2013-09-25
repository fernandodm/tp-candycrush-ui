package Tp.CandyCrush;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CarameloTest extends TestCase {

	private Caramelo caramelo1;
	private Tablero t;
	private Coordenada cor1;	
	private Coordenada cor2;
	private Caramelo caramelo2;
	private Caramelo[][] caramelos = new Caramelo[2][1];
	
	public void setUp(){
		caramelo1 = new Caramelo("Rojo");
		caramelo2 = new Caramelo("Verde");
		
		caramelos[1][0] = caramelo1;
		caramelos[0][0] = caramelo2;
		
		cor2 = new Coordenada(0,0);
		cor1= new Coordenada(1,0);
		
		t = new Tablero();
		t.setAlto(2); 
		t.setAncho(1);
		t.setCaramelos(caramelos);
	}
	
	public void testConstructor(){
		Assert.assertEquals(caramelo1.getColor(), "Rojo");
	}
	
	public void testSwapCaramelos(){
		Caramelo.swapCaramelos(t, cor1, cor2);
		Assert.assertEquals("Verde", t.colorCarameloEn(cor1));
		Assert.assertEquals("Rojo", t.colorCarameloEn(cor2));
	}
}
