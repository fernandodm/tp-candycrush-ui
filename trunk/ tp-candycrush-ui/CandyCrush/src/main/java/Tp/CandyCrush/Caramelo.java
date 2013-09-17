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

	public void swapCaramelos(Tablero t, Coordenada c1, Coordenada c2){
		Caramelo aux = t.getCaramelos()[c1.getFila()][c1.getColumna()];
		t.getCaramelos()[c1.getFila()][c1.getColumna()] = t.getCaramelos()[c2.getFila()][c2.getColumna()];
		t.getCaramelos()[c2.getFila()][c2.getColumna()] = aux;
	}
	
}
