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
	private Coordenada cor00;
	private Coordenada cor01;
	private Coordenada cor02;
	private Coordenada cor03;
	private Coordenada cor04;
	private Coordenada cor10;
	private Coordenada cor11;
	private Coordenada cor12;
	private Coordenada cor13;
	private Coordenada cor14;
	private Coordenada cor20;
	private Coordenada cor21;
	private Coordenada cor22;
	private Coordenada cor23;
	private Coordenada cor24;
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
		
		cor00 = mock(Coordenada.class);
		cor01 = mock(Coordenada.class);
		cor02 = mock(Coordenada.class);
		cor03 = mock(Coordenada.class);
		cor04 = mock(Coordenada.class);
		cor10 = mock(Coordenada.class);
		cor11 = mock(Coordenada.class);
		cor12 = mock(Coordenada.class);
		cor13 = mock(Coordenada.class);
		cor14 = mock(Coordenada.class);
		cor20 = mock(Coordenada.class);
		cor21 = mock(Coordenada.class);
		cor22 = mock(Coordenada.class);
		cor23 = mock(Coordenada.class);
		cor24 = mock(Coordenada.class);
		
		when(cor00.getFila()).thenReturn(0);
		when(cor00.getColumna()).thenReturn(0);
		when(cor01.getFila()).thenReturn(0);
		when(cor01.getColumna()).thenReturn(1);
		when(cor02.getFila()).thenReturn(0);
		when(cor02.getColumna()).thenReturn(2);
		when(cor03.getFila()).thenReturn(0);
		when(cor03.getColumna()).thenReturn(3);
		when(cor04.getFila()).thenReturn(0);
		when(cor04.getColumna()).thenReturn(4);
		when(cor10.getFila()).thenReturn(1);
		when(cor10.getColumna()).thenReturn(0);
		when(cor11.getFila()).thenReturn(1);
		when(cor11.getColumna()).thenReturn(1);
		when(cor12.getFila()).thenReturn(1);
		when(cor12.getColumna()).thenReturn(2);
		when(cor13.getFila()).thenReturn(1);
		when(cor13.getColumna()).thenReturn(3);
		when(cor14.getFila()).thenReturn(1);
		when(cor14.getColumna()).thenReturn(4);
		when(cor20.getFila()).thenReturn(2);
		when(cor20.getColumna()).thenReturn(0);
		when(cor21.getFila()).thenReturn(2);
		when(cor21.getColumna()).thenReturn(1);
		when(cor22.getFila()).thenReturn(2);
		when(cor22.getColumna()).thenReturn(2);
		when(cor23.getFila()).thenReturn(2);
		when(cor23.getColumna()).thenReturn(3);
		when(cor24.getFila()).thenReturn(2);
		when(cor24.getColumna()).thenReturn(4);
	
			
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
		Assert.assertTrue(tablero.incluidoEnTablero(cor12));	
	}
	
	public void testIncluidoEnTableroCasoFalse(){
		Coordenada cor3 = mock(Coordenada.class);
		
		when(cor3.getFila()).thenReturn(5);
		when(cor3.getColumna()).thenReturn(5);
		
		Assert.assertFalse(tablero.incluidoEnTablero(cor3));	
	}
	
	public void testColorCarameloEnCasoTrue(){
		tablero.getCaramelos()[1][2] = caramelo1;
		Assert.assertEquals("Verde", tablero.colorCarameloEn(cor12));
	}
	
	public void testColorCaremeloEnCasoFalse(){
		when(cor12.getFila()).thenReturn(20);
		when(cor12.getColumna()).thenReturn(20);
		Assert.assertEquals(" ", tablero.colorCarameloEn(cor12));
	}
	
	public void testSwapCaramelos(){
		t.swapCaramelos(cor00, cor01);
		Assert.assertEquals("Verde", t.colorCarameloEn(cor00));
		Assert.assertEquals("Rojo", t.colorCarameloEn(cor01));
	}
	
	public void testTraerVecinoA(){
		String [] cols = new String[3]; 
		cols[0] = "Rojo";
		cols[1] = "vacio";
		cols[2] = "vacio";
		String esperado = t.traerVecinoA(cols, 2);
		Assert.assertEquals(esperado, cols[2]);
	}
	
	public void testDejarVacioArriba(){
		String [] cols = new String[3]; 
		cols[0] = "Rojo";
		cols[1] = "vacio";
		cols[2] = "vacio";
		cols = t.dejarVaciosArriba(cols);
		Assert.assertEquals("Rojo", cols[2]);
		Assert.assertEquals("vacio", cols[1]);
		Assert.assertEquals("vacio", cols[0]);
	}
	
	/*public void testHayVecinoParaIntercambiarCasoTrue(){
		Assert.assertTrue(t.hayVecinoParaIntercambiar(cor23) && t.hayVecinoParaIntercambiar(cor11));
	}
	
	public void testHayVecinoParaIntercambiarCasoFalse(){
		Assert.assertFalse(t.hayVecinoParaIntercambiar(cor13) && t.hayVecinoParaIntercambiar(cor24));
	}*/
	
	public void testLlenarConAleatorios(){
		String [] cols = new String[3]; 
		cols[0] = "vacio";
		cols[1] = "vacio";
		cols[2] = "vacio";
		cols = t.llenarConAleatorios(cols);
		Assert.assertEquals("Verde", cols[2]);
		Assert.assertEquals("Verde", cols[1]);
		Assert.assertEquals("Verde", cols[0]);
	}
	
	public void testBajarCaramelosEnColumnaCol3(){
		t.bajarCaramelosEnColumna(3);
		String col03 = t.colorCarameloEn(cor03);
		String col13 = t.colorCarameloEn(cor13);
		String col23 = t.colorCarameloEn(cor23);
		Assert.assertEquals("Verde", col03);
		Assert.assertEquals("Verde", col13);
		Assert.assertEquals("Rojo", col23);
	}
	
	public void testBajarCaramelosEnColumnaCol4(){
		t.bajarCaramelosEnColumna(4);
		String col04 = t.colorCarameloEn(cor04);
		String col14 = t.colorCarameloEn(cor14);
		String col24 = t.colorCarameloEn(cor24);
		Assert.assertEquals("Verde", col04);
		Assert.assertEquals("Verde", col14);
		Assert.assertEquals("Verde", col24);
	}
	
	
	public void testBajarCaramelos(){
	/*	List<Coordenada> coors = new ArrayList<Coordenada>();
		coors.add(cor04); coors.add(cor13); 
		coors.add(cor14);
		coors.add(cor23); 
		coors.add(cor24);;
		Tablero t1 = t.bajarCaramelos(coors);
		String col00 = t1.colorCarameloEn(cor00);
		String col01 = t1.colorCarameloEn(cor01);
		String col02 = t1.colorCarameloEn(cor02);
		String col03 = t1.colorCarameloEn(cor03);
		String col04 = t1.colorCarameloEn(cor04);
		String col10 = t1.colorCarameloEn(cor10);
		String col11 = t1.colorCarameloEn(cor11);
		String col12 = t1.colorCarameloEn(cor12);
		String col13 = t1.colorCarameloEn(cor13);
		String col14 = t1.colorCarameloEn(cor14);
		String col20 = t1.colorCarameloEn(cor20);
		String col21 = t1.colorCarameloEn(cor21);
		String col22 = t1.colorCarameloEn(cor22);
		String col23 = t1.colorCarameloEn(cor23);
		String col24 = t1.colorCarameloEn(cor24);
		Assert.assertEquals("Rojo", col00);
		Assert.assertEquals("Verde", col01);
		Assert.assertEquals("Rojo", col02);
		Assert.assertEquals("Verde", col03);
	//	Assert.assertEquals("Rojo", col03); //
		Assert.assertEquals("Verde", col04);
		Assert.assertEquals("Rojo", col10);
		Assert.assertEquals("Verde", col11);
		Assert.assertEquals("Rojo", col12);
		Assert.assertEquals("Verde", col13);
		Assert.assertEquals("Verde", col14);	
		Assert.assertEquals("Verde", col20);
		Assert.assertEquals("Verde", col21);
		Assert.assertEquals("Rojo", col23);
	//	Assert.assertEquals("Verde", col23); //
		Assert.assertEquals("Verde", col24);*/
		
	
	}
}
