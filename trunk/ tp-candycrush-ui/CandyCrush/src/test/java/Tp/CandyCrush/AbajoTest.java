package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class AbajoTest extends TestCase {
	
	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Abajo abajo;
	
	public void setUp(){
		
		Caramelo[][] caramelos = new Caramelo[5][5];
		caramelos[2][4] = caramelo1;
		caramelos[2][5] = caramelo2;
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(6);
		when(tablero.getAncho()).thenReturn(6);
		when(tablero.getCaramelos()).thenReturn(caramelos);
		
		abajo = new Abajo();
		abajo.setTablero(tablero);
		
		caramelo1 = mock(Caramelo.class);
		when(caramelo1.getX()).thenReturn(2);
		when(caramelo1.getY()).thenReturn(4);
		
		caramelo2 = mock(Caramelo.class);
		when(caramelo2.getX()).thenReturn(2);
		when(caramelo1.getY()).thenReturn(5);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		abajo.realizar(caramelo1);
		verify(tablero).swapCaramelos(caramelo1, caramelo2);
	}
	
	public void testMoverNOPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		try{
			abajo.realizar(caramelo2);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
	
	
}
