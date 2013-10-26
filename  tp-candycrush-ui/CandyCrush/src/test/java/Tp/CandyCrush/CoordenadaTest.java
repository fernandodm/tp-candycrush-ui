package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CoordenadaTest extends TestCase {

	private Coordenada c1;
	private Coordenada c2;
	private Coordenada c3;
	private Coordenada c4;
	private Coordenada c5;
	private List<Coordenada> coors = new ArrayList<Coordenada>();
	private List<Movimiento> moves = new ArrayList<Movimiento>();
	private Abajo mov1;
	private Izquierda mov2;
	
	public void setUp(){
		c1 = new Coordenada(2, 3);
		c2 = new Coordenada(2, 3);
		c3 = new Coordenada(3,7);
		c4 = new Coordenada(1,4);
		c5 = new Coordenada(2,5);
		mov1 = new Abajo();
		mov2 = new Izquierda();
		moves.add(mov1);
		moves.add(mov2);
		coors.add(c3);
		coors.add(c2);
		coors.add(c4);
		coors.add(c5);
	}
	
	public void testConstructor(){
		Assert.assertEquals(c2.getFila(), 2);
		Assert.assertEquals(c2.getColumna(), 3);
	}
	
	public void testCoordenadaResultante(){
		c1 = c1.coordenadaResultante(moves);
		Assert.assertEquals(3, c1.getFila());
		Assert.assertEquals(2, c1.getColumna());
	}
	
	public void testTienePrioridadCasoTrue(){
		Assert.assertTrue(c3.tienePrioridad(c1));
	}
	
	public void testTienePrioridadCasoFalse(){
		Assert.assertFalse(c1.tienePrioridad(c2));
	}
	
	public void testOrdenarParaRellenar(){
		List<Coordenada> ord = Coordenada.ordenarParaRellenar(coors);
		boolean esperado = ord.get(0) == c3 && ord.get(1) == c2 && ord.get(2) == c5 && ord.get(3) == c4;
		Assert.assertTrue(esperado);				
	}
	
	public void testJPTuEclipseApesta(){
		double a = 6.7;
		double b = 6.7;
		Assert.assertEquals(a, b);
	}
	
}

