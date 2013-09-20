package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Caramelo {
	private String color;
		
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public Caramelo(String color){
		this.setColor(color);
	}

	public static void swapCaramelos(Tablero t, Coordenada c1, Coordenada c2){
		String aux = t.getCaramelos()[c1.getFila()][c1.getColumna()].getColor();
		t.getCaramelos()[c1.getFila()][c1.getColumna()].setColor(t.getCaramelos()[c2.getFila()][c2.getColumna()].getColor());
		t.getCaramelos()[c2.getFila()][c2.getColumna()].setColor(aux);
	}
	
	public static boolean sonDelMismoColor(Tablero t, Coordenada c1, Coordenada c2){
		return Caramelo.colorCaramelo(t, c1).equals(Caramelo.colorCaramelo(t, c2));
	}
	
	public static String colorCaramelo(Tablero t, Coordenada c){
		return t.getCaramelos()[c.getColumna()][c.getFila()].getColor();
	}
}
