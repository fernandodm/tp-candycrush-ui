package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;
import junit.framework.TestCase;

public class CarameloTest extends TestCase {

	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Caramelo caramelo3;
	private Tablero tab;
	private Coordenada c1;
	private Coordenada c2;
	private Coordenada c3;
	
	public void setUp(){
		caramelo1 = new Caramelo("Rojo");
		caramelo2 = new Caramelo("Rojo");
		caramelo3 = new Caramelo("Vede");
		tab = mock(Tablero.class);
		c1 = mock(Coordenada.class);
		c2 = mock(Coordenada.class);
		when(Caramelo.colorCaramelo(tab, c1)).thenReturn("Rojo");
		when(Caramelo.colorCaramelo(tab, c2)).thenReturn("Verde");
		when(Caramelo.colorCaramelo(tab, c3)).thenReturn("Rojo");
		
	}
	
	public void testConstructor(){
		Assert.assertEquals(caramelo1.getColor(), "Rojo");
	}
	
	public void testColorCarameloCasoTrue(){
		Assert.assertTrue(Caramelo.sonDelMismoColor(tab, c1, c3));
	}
	
	public void testColorCarameloCasoFalse(){
		Assert.assertTrue(Caramelo.sonDelMismoColor(tab, c1, c2));
	}
	
	public void testSonDelMismoColorIguales(){
	
	
	}
}
