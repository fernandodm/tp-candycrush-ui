package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;

public class IzquierdaTest extends TestCase {

	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Izquierda izquierda;
	
	public void setUp(){
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		
		izquierda = new Izquierda();
		izquierda.setTablero(tablero);
		
		caramelo1 = mock(Caramelo.class);
		when(caramelo1.getX()).thenReturn(1);
		when(caramelo1.getY()).thenReturn(0);
		
		caramelo2 = mock(Caramelo.class);
		when(caramelo2.getX()).thenReturn(0);
		when(caramelo1.getY()).thenReturn(0);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		izquierda.realizar(caramelo1);
		verify(tablero).swapCaramelos(caramelo1, caramelo2);
	}
	
	public void testMoverNOPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		try{
			izquierda.realizar(caramelo2);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
	
}
