package Tp.CandyCrush;

import java.io.Serializable;

public class Caramelo implements Serializable {
	
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
	
	public static String colorCaramelo(Tablero t, Coordenada c){
		return t.getCaramelos()[c.getColumna()][c.getFila()].getColor();
	}
	

}
