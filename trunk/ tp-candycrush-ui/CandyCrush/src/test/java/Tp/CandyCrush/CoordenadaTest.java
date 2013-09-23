package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CoordenadaTest extends TestCase {

	private Coordenada c1;
	private Coordenada c2;
	private List<Movimiento> moves = new ArrayList<Movimiento>();
	private Abajo mov1;
	private Izquierda mov2;
	
	public void setUp(){
		c1 = new Coordenada(2, 3);
		c2 = new Coordenada(2, 3);
		mov1 = new Abajo();
		mov2 = new Izquierda();
		moves.add(mov1);
		moves.add(mov2);
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
}
