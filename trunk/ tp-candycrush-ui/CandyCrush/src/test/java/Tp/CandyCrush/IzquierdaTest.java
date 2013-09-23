package Tp.CandyCrush;

import Tp.CandyCrush.Izquierda;
import junit.framework.TestCase;
import junit.framework.Assert;
import static org.mockito.Mockito.*;

public class IzquierdaTest extends TestCase {
	
	private Coordenada c;
	private Izquierda izquierda;
	
	public void setUp(){
		c = mock(Coordenada.class);
		izquierda = new Izquierda();
		when(c.getFila()).thenReturn(4);
		when(c.getColumna()).thenReturn(5);
	}
	
	public void testCoordenadaMovimiento(){
		c= izquierda.coordenadaMovimiento(c);
		Assert.assertEquals(c.getFila(), 4);
		Assert.assertEquals(c.getColumna(), 4);
	}

}
