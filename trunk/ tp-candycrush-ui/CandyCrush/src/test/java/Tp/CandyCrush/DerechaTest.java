package Tp.CandyCrush;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import excepciones.ExcepcionNoSePuedeMover;
import junit.framework.TestCase;

public class DerechaTest extends TestCase {

	private Tablero tablero;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	private Derecha derecha;
	
	public void setUp(){
		
		tablero = mock(Tablero.class);
		when(tablero.getAlto()).thenReturn(5);
		when(tablero.getAncho()).thenReturn(5);
		
		derecha = new Derecha();
		derecha.setTablero(tablero);
		
		caramelo1 = mock(Caramelo.class);
		when(caramelo1.getX()).thenReturn(4);
		when(caramelo1.getY()).thenReturn(0);
		
		caramelo2 = mock(Caramelo.class);
		when(caramelo2.getX()).thenReturn(5);
		when(caramelo1.getY()).thenReturn(0);
	}
	
	public void testMoverPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		derecha.realizar(caramelo1);
		verify(caramelo1).swapPosicionesCon(caramelo2);
	}
	
	public void testMoverNOPudiendoMover() throws ExcepcionNoSePuedeMover{
		
		try{
			derecha.realizar(caramelo2);
			fail();
		} catch (ExcepcionNoSePuedeMover e){
			
		}
	}
	
	
}
