package Tp.CandyCrush;


import org.junit.Assert;
import Tp.CandyCrush.ExplosionesPorColor;
import Tp.CandyCrush.Explosion;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class ExplosionesPorColorTest extends TestCase {

	private ExplosionesPorColor epc;
	private Explosion explosion;
	
	public void setUp(){
		
		epc = new ExplosionesPorColor("Rojo", 5);
		explosion = mock(Explosion.class);
		when(explosion.getColor()).thenReturn("Rojo");
		when(explosion.getCantidad()).thenReturn(5);
		
	}
	
	public void testActualizarObjetivoTrue(){
		
		epc.actualizarObjetivo(explosion);
		Assert.assertTrue(epc.isSeCumplio());
	}
	
	public void testActualizarObjetivoFalse(){
		
		when(explosion.getColor()).thenReturn("Azul");
		when(explosion.getCantidad()).thenReturn(3);
		epc.actualizarObjetivo(explosion);
		Assert.assertFalse(epc.isSeCumplio());
	}
	
	public void testComplete(){
		
		epc.complete();
		Assert.assertFalse(epc.isSeCumplio());
	}
	
}
