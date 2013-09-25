package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;

import junit.framework.TestCase;

public class GrandesExplosionesTest extends TestCase {
	
	private GrandesExplosiones gp;
	private Explosion explosion;
	private Explosion explosion2;
	private Explosion explosion3;
	
	public void setUp(){
		
		gp = new GrandesExplosiones("Rojo", 2);
		explosion = mock(Explosion.class);
		when(explosion.getColor()).thenReturn("Rojo");
		when(explosion.getCantidad()).thenReturn(4);
		
		explosion2 = mock(Explosion.class);
		when(explosion2.getColor()).thenReturn("Rojo");
		when(explosion2.getCantidad()).thenReturn(5);
		
		explosion3 = mock(Explosion.class);
		when(explosion3.getColor()).thenReturn("Rojo");
		when(explosion3.getCantidad()).thenReturn(3);
		
	}
	
	public void testActualizarObjetivoFalse(){
		
		gp.actualizarObjetivo(explosion);
		Assert.assertFalse(gp.isSeCumplio());
	}
	
public void testActualizarObjetivoFalse2(){
		
		gp.actualizarObjetivo(explosion);
		gp.actualizarObjetivo(explosion3);
		
		Assert.assertFalse(gp.isSeCumplio());
	}
	
	
	public void testActualizarObjetivoTrue(){
		
		gp.actualizarObjetivo(explosion);
		gp.actualizarObjetivo(explosion2);
		Assert.assertTrue(gp.isSeCumplio());
	}
	
	public void testComplete(){
		
		gp.complete();
		Assert.assertFalse(gp.isSeCumplio());
	}

}
