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
		
		caramelo1 = mock(Caramelo.class);
		caramelo2 = mock(Caramelo.class);
		
		Caramelo[][] caramelos = new Caramelo[5][5];
		caramelos[3][1] = caramelo1;
		caramelos[4][1] = caramelo2;
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		when(tablero.getCaramelos()).thenReturn(caramelos);
		
		abajo = new Abajo();
		abajo.setTablero(tablero);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		abajo.realizar(3,1);
		verify(tablero).swapCaramelos(3,1,4,1);
		
		
	}
	
	public void testMoverNOPudiendoMover(){
		
		try{
			abajo.realizar(4,1);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
}
