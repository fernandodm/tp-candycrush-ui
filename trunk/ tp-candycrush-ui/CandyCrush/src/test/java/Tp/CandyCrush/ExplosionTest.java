package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ExplosionTest extends TestCase {

	private Explosion explosion;
	private Tablero t;
	private Caramelo car1;
	private Caramelo car2;
	private Coordenada cor;
	private Coordenada cor3;
	private Caramelo[][] caramelos = new Caramelo [3] [3];
	private List<Movimiento> vecino1 = new ArrayList<Movimiento>();
	private List<Movimiento> vecino2 = new ArrayList<Movimiento>();
	private Arriba arriba = new Arriba();
	
	
	public void setUp(){
		explosion = new Explosion(5, "Rojo");

		cor = new Coordenada(2,1);
		cor3 = new Coordenada(1,0);
		
		car1 = mock(Caramelo.class);
		car2 = mock(Caramelo.class);
	
		caramelos [0][0] = car2;
		caramelos [0][1] = car1;
		caramelos [0][2] = car2;
		caramelos [1][0] = car2;
		caramelos [1][1] = car1;
		caramelos [1][2] = car2;
		caramelos [2][0] = car1;
		caramelos [2][1] = car1;
		caramelos [2][2] = car1;
		
		vecino1.add(arriba);
		vecino2.add(arriba); 
		vecino2.add(arriba);
		
		t = new Tablero();
		t.setAlto(3);
		t.setAncho(3);
		t.setCaramelos(caramelos);

		
		when(car1.getColor()).thenReturn("Verde");
		when(car2.getColor()).thenReturn("Rojo");

	}
	
	public void testConstructor(){
		Assert.assertEquals(explosion.getColor(), "Rojo");
		Assert.assertEquals(explosion.getCantidad(), 5);
	}
	
	public void testExplosionHaciaCasoTrue(){
		Coordenada vec1 = cor.coordenadaResultante(vecino1);
		Coordenada vec2 = cor.coordenadaResultante(vecino2);
		Assert.assertTrue(explosion.explosionHacia(t, cor, vec1, vec2));
	}
	
	public void testExplosionHaciaCasoFalse(){
		Coordenada cor2 = new Coordenada(2,2);
		Coordenada vec1 = cor2.coordenadaResultante(vecino1);
		Coordenada vec2 = cor2.coordenadaResultante(vecino2);
		Assert.assertFalse(explosion.explosionHacia(t, cor2, vec1, vec2));
	}
	
	public void testExplotaVerticalCasoTrue(){
		Assert.assertTrue(explosion.explotaVertical(t, cor));
	}
	
	public void testExplotaVerticalCasoFalse(){
		Assert.assertFalse(explosion.explotaVertical(t, cor3));
	}
	
	public void testExplotaHorizontalCasoTrue(){
		Assert.assertTrue(explosion.explotaHorizontal(t, cor));
	}
	
	public void testExplotaHorizontalCasoFalse(){
		Assert.assertFalse(explosion.explotaHorizontal(t, cor3));
	}
	
	public void testGeneroExplosionCasoTrue(){
		Assert.assertTrue(explosion.generoExplosion(t, cor));
	}
	
	public void testGeneroExplesionCasoFalse(){
		Assert.assertFalse(explosion.generoExplosion(t, cor3));
	}
	
	
}
