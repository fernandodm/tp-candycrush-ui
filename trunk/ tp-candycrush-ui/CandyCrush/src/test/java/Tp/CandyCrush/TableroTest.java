package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class TableroTest extends TestCase {
	private Tablero tablero;
	private Nivel nivel;
	
	public void setUp(){
		tablero = new Tablero();
		
		nivel = mock(Nivel.class);
		
		List<String> colores = new ArrayList<String>();
		colores.add("Amarillo");
		colores.add("Celeste");
		colores.add("Verde");
		colores.add("Rojo");
		
		when(nivel.cantidadDeCaramelos()).thenReturn(4);
		when(nivel.caramelosDelNivel()).thenReturn(colores);// Nivel Facil
		
		
		
	}

	
	public void testIniciar(){
		
		tablero.iniciar(2, 3, nivel);
		Caramelo[][] caramelo = tablero.getCaramelos();
		int cantidad = 0;
		
		for(int x = 0; x < 2; x++){
			for(int y = 0; y < 3; y++){
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
