package Tp.CandyCrush;

import Tp.CandyCrush.Derecha;
import junit.framework.TestCase;
import junit.framework.Assert;
import static org.mockito.Mockito.*;

public class DerechaTest extends TestCase {
	
	private Coordenada c;
	private Derecha derecha;
	
	public void setUp(){
		c = mock(Coordenada.class);
		derecha = new Derecha();
		when(c.getFila()).thenReturn(4);
		when(c.getColumna()).thenReturn(5);
	}
	
	public void testCoordenadaMovimiento(){
		c= derecha.coordenadaMovimiento(c);
		Assert.assertEquals(c.getFila(), 4);
		Assert.assertEquals(c.getColumna(), 6);
	}

}