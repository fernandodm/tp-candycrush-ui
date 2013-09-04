package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import Tp.CandyCrush.Arriba;
import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Tablero;
import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;

public class ArribaTest extends TestCase {

	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Arriba arriba;
	
	public void setUp(){
		
		caramelo1 = mock(Caramelo.class);
		caramelo2 = mock(Caramelo.class);
		
		Caramelo[][] caramelos = new Caramelo[5][5];
		caramelos[1][1] = caramelo1;
		caramelos[0][1] = caramelo2;
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		when(tablero.getCaramelos()).thenReturn(caramelos);
		
		arriba = new Arriba();
		arriba.setTablero(tablero);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		arriba.realizar(1,1);
		verify(tablero).swapCaramelos(1,1,0,1);
	}
	
	public void testMoverNOPudiendoMover(){
		
		try{
			arriba.realizar(0,1);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
}
