package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Nivel;
import Tp.CandyCrush.Tablero;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class TableroTest extends TestCase {
	private Tablero tablero;
	private Nivel nivel;
	private Caramelo caramelo1;
	private Caramelo caramelo2;
	
	public void setUp(){
		
		caramelo1 = mock(Caramelo.class);
		caramelo2 = mock(Caramelo.class);
		
		Caramelo[][] caramelos = new Caramelo[3][5];
		caramelos[2][2] = caramelo1;
		caramelos[1][3] = caramelo2;
		
		nivel = mock(Nivel.class);
		tablero = new Tablero();
		tablero.setCaramelos(caramelos);
		tablero.setAlto(2);
		tablero.setAncho(3);
		tablero.setUnNivel(nivel);

		when(nivel.carameloAleatorio()).thenReturn(caramelo1);
		
	}

	public void testIniciar(){
		
		tablero.iniciar();
		Caramelo[][] caramelo = tablero.getCaramelos();
		int cantidad = 0;
		
		for(int x = 0; x < tablero.getAlto(); x++){
			for(int y = 0; y < tablero.getAncho(); y++){
				if(caramelo[x][y] != null){
					cantidad = cantidad + 1;
				}else{
					fail();
				}
		
			}
		}
		Assert.assertTrue(cantidad == 6);
	}
}
