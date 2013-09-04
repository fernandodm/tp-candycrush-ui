package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Izquierda;
import Tp.CandyCrush.Tablero;
import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;

public class IzquierdaTest extends TestCase {

	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Izquierda izquierda;
	
	public void setUp(){
		
		caramelo1 = mock(Caramelo.class);
		caramelo2 = mock(Caramelo.class);
		
		Caramelo[][] caramelos = new Caramelo[5][5];
		caramelos[1][1] = caramelo1;
		caramelos[1][0] = caramelo2;
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		when(tablero.getCaramelos()).thenReturn(caramelos);
		
		izquierda = new Izquierda();
		izquierda.setTablero(tablero);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		izquierda.realizar(1,1);
		verify(tablero).swapCaramelos(1,1,1,0);
	}
	
	public void testMoverNOPudiendoMover(){
		
		try{
			izquierda.realizar(1,0);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
}
