package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Derecha;
import Tp.CandyCrush.Tablero;
import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;

public class DerechaTest extends TestCase {

	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Derecha derecha;
	
	public void setUp(){
		
		caramelo1 = mock(Caramelo.class);
		caramelo2 = mock(Caramelo.class);
		
		Caramelo[][] caramelos = new Caramelo[5][5];
		caramelos[0][3] = caramelo1;
		caramelos[0][4] = caramelo2;
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		when(tablero.getCaramelos()).thenReturn(caramelos);
		
		derecha = new Derecha();
		derecha.setTablero(tablero);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		derecha.realizar(0,3);
		verify(tablero).swapCaramelos(0,3,0,4);
	}
	
	public void testMoverNOPudiendoMover(){
		
		try{
			derecha.realizar(0,4);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
}
