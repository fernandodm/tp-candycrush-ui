package Tp.CandyCrush;

import Tp.CandyCrush.Abajo;
import junit.framework.TestCase;
import junit.framework.Assert;
import static org.mockito.Mockito.*;

public class AbajoTest extends TestCase {
	
	private Coordenada c;
	private Abajo abajo;
	
	public void setUp(){
		c = mock(Coordenada.class);
		abajo = new Abajo();
		when(c.getFila()).thenReturn(4);
		when(c.getColumna()).thenReturn(5);
	}
	
	public void testCoordenadaMovimiento(){
		c= abajo.coordenadaMovimiento(c);
		Assert.assertEquals(c.getFila(), 5);
		Assert.assertEquals(c.getColumna(), 5);
	}

}
