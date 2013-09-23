package Tp.CandyCrush;

import Tp.CandyCrush.Arriba;
import junit.framework.TestCase;
import junit.framework.Assert;
import static org.mockito.Mockito.*;

public class ArribaTest extends TestCase {
	
	private Coordenada c;
	private Arriba arriba;
	
	public void setUp(){
		c = mock(Coordenada.class);
		arriba = new Arriba();
		when(c.getFila()).thenReturn(4);
		when(c.getColumna()).thenReturn(5);
	}
	
	public void testCoordenadaMovimiento(){
		c= arriba.coordenadaMovimiento(c);
		Assert.assertEquals(c.getFila(), 3);
		Assert.assertEquals(c.getColumna(), 5);
	}

}
