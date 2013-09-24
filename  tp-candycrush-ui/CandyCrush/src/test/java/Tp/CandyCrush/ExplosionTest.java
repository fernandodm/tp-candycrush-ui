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
	private Caramelo[][] caramelos = new Caramelo [3] [3];
	private List<Movimiento> moves = new ArrayList<Movimiento>();
	private List<Movimiento> vecino1 = new ArrayList<Movimiento>();
	private List<Movimiento> vecino2 = new ArrayList<Movimiento>();
	private Derecha mov1;
	private Izquierda mov2;
	
	public void setUp(){
		explosion = new Explosion(5, "Rojo");
		//t = mock(Tablero.class);
		car1 = mock(Caramelo.class);
		car2 = mock(Caramelo.class);
		cor = mock(Coordenada.class);
		caramelos [0][0] = car1;
		caramelos [0][1] = car1;
		caramelos [0][2] = car1;
		caramelos [1][0] = car1;
		caramelos [1][1] = car1;
		caramelos [1][2] = car1;
		caramelos [2][0] = car1;
		caramelos [2][1] = car1;
		caramelos [2][2] = car1;
		t = new Tablero();
		t.setAlto(3);
		t.setAncho(3);
		t.setCaramelos(caramelos);
		/*when(t.getCaramelos()).thenReturn(caramelos);
		when(t.getAlto()).thenReturn(3);
		when(t.getAncho()).thenReturn(3);*/
		when(cor.getFila()).thenReturn(2);
		when(cor.getColumna()).thenReturn(1);
		when(car1.getColor()).thenReturn("Verde");
		when(car2.getColor()).thenReturn("Rojo");

	}
	
	public void testConstructor(){
		Assert.assertEquals(explosion.getColor(), "Rojo");
		Assert.assertEquals(explosion.getCantidad(), 5);
	}
	
	public void testExplosionHacia(){
		mov1 = new Derecha();
		mov2 = new Izquierda();
		vecino1.add(mov2);
		vecino2.add(mov1);
		Assert.assertTrue(explosion.explosionHacia(t, cor, vecino1, vecino2));
	}
	
	public void testExplotaVertical(){
		Assert.assertFalse(explosion.explotaVertical(t, cor));
	}
	
}
