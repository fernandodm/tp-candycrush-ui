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
	private Caramelo caramelo3;
	private Coordenada cor1;
	private Coordenada cor2;
	private Coordenada cor4;
	private Coordenada cor5;
	private Coordenada cor6;
	private Tablero t;
	private Caramelo[][] caramelos2 = new Caramelo [3] [5];
	private List<Movimiento> vecino1 = new ArrayList<Movimiento>();
	private List<Movimiento> vecino2 = new ArrayList<Movimiento>();
	private Arriba arriba = new Arriba();
	
	
	public void setUp(){
		
		caramelo1 = new Caramelo("Verde");
		caramelo2 = new Caramelo("Rojo");
		caramelo3 = new Caramelo("vacio");
		
		Caramelo[][] caramelos = new Caramelo[2][3];
		caramelos[1][2] = caramelo1;
		caramelos[0][2] = caramelo2;
		
		nivel = mock(Nivel.class);
		tablero = new Tablero();
		tablero.setCaramelos(caramelos);
		tablero.setAlto(2);
		tablero.setAncho(3);
		tablero.setNivel(nivel);
		
		cor1 = mock(Coordenada.class);
		cor2 = mock(Coordenada.class);
		cor4 = mock(Coordenada.class);
		cor5 = mock(Coordenada.class);
		cor6 = mock(Coordenada.class);
		
		when(cor1.getFila()).thenReturn(1);
		when(cor1.getColumna()).thenReturn(2);
		when(cor2.getFila()).thenReturn(0);
		when(cor2.getColumna()).thenReturn(2);
		when(cor4.getFila()).thenReturn(2);
		when(cor4.getColumna()).thenReturn(3);
		when(cor5.getFila()).thenReturn(2);
		when(cor5.getColumna()).thenReturn(4);
		when(cor6.getFila()).thenReturn(1);
		when(cor6.getColumna()).thenReturn(0);
		
		when(nivel.carameloAleatorio()).thenReturn(caramelo1);
		
		//explosion = new Explosion(5, "Rojo");
		
	/*	car1 = mock(Caramelo.class);
		car2 = mock(Caramelo.class);
		car3= mock(Caramelo.class);
	*/
		caramelos2 [0][0] = caramelo2;
		caramelos2 [0][1] = caramelo1;
		caramelos2 [0][2] = caramelo2;
		caramelos2 [1][0] = caramelo2;
		caramelos2 [1][1] = caramelo1;
		caramelos2 [1][2] = caramelo2;
		caramelos2 [2][0] = caramelo1;
		caramelos2 [2][1] = caramelo1;
		caramelos2 [2][2] = caramelo1;
		caramelos2 [0][3] = caramelo2;
		caramelos2 [1][3] = caramelo3;
		caramelos2 [2][3] = caramelo3;
		caramelos2 [0][4] = caramelo3;
		caramelos2 [1][4] = caramelo3;
		caramelos2 [2][4] = caramelo3;
		
		vecino1.add(arriba);
		vecino2.add(arriba); 
		vecino2.add(arriba);
		
		t = new Tablero();
		t.setAlto(3);
		t.setAncho(5);
		t.setCaramelos(caramelos2);
		t.setNivel(nivel);
		
	/*	when(car1.getColor()).thenReturn("Verde");
		when(car2.getColor()).thenReturn("Rojo");
		when(car3.getColor()).thenReturn("vacio");
	*/
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
	
	public void testIncluidoEnTableroCasoTrue(){
		Assert.assertTrue(tablero.incluidoEnTablero(cor1));	
	}
	
	public void testIncluidoEnTableroCasoFalse(){
		Coordenada cor3 = mock(Coordenada.class);
		
		when(cor3.getFila()).thenReturn(5);
		when(cor3.getColumna()).thenReturn(5);
		
		Assert.assertFalse(tablero.incluidoEnTablero(cor3));	
	}
	
	public void testColorCarameloEnCasoTrue(){
		tablero.getCaramelos()[1][2] = caramelo1;
		Assert.assertEquals("Verde", tablero.colorCarameloEn(cor1));
	}
	
	public void testColorCaremeloEnCasoFalse(){
		when(cor1.getFila()).thenReturn(20);
		when(cor1.getColumna()).thenReturn(20);
		Assert.assertEquals(" ", tablero.colorCarameloEn(cor1));
	}
	
	public void testSwapCaramelos(){
		tablero.swapCaramelos(cor2, cor1);
		Assert.assertEquals("Verde", tablero.colorCarameloEn(cor2));
		Assert.assertEquals("Rojo", tablero.colorCarameloEn(cor1));
	}
	
	public void testBajarCarameloODameUnoNuevoCasoIntercambio(){
		t.bajarCarameloODameUnoNuevo(cor4);
		String col = t.colorCarameloEn(cor4);
		Assert.assertEquals("Rojo", col);
	}
	
	public void testBajarCarameloODameUnoNuevoCasoDameUnoAleatorio(){
		t.bajarCarameloODameUnoNuevo(cor5);
		String col = t.colorCarameloEn(cor5);
		Assert.assertEquals("Verde", col);
	}
	
	public void testDameUnCarameloAleatorio(){
		t.dameUnCarameloAleatorio(cor6);
		String col = t.colorCarameloEn(cor6);
		Assert.assertEquals("Verde", col);
	}
	
	public void testBajarCarameloEnCoordenadaCasoLleno(){
		t.bajarCarameloEnCoordenada(cor4);
		String col = t.colorCarameloEn(cor4);
		Assert.assertEquals("Rojo", col);
	}
	
	public void testBajarCarameloEnCoordenadaCasoVacio(){
		t.bajarCarameloEnCoordenada(cor5);
		String col = t.colorCarameloEn(cor5);
		Assert.assertEquals("Verde", col);
	}
	
	
	
	
}
