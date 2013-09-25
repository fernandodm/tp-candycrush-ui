package Tp.CandyCrush;

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
	
	public static String colorCaramelo(Tablero t, Coordenada c){
		return t.getCaramelos()[c.getColumna()][c.getFila()].getColor();
	}
}
