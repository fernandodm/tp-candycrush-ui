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

	public static void swapCaramelos(Tablero t, Coordenada c1, Coordenada c2){
		String col1 = t.colorCarameloEn(c1);
		String col2 = t.colorCarameloEn(c2);
		t.getCaramelos()[c1.getFila()][c1.getColumna()].setColor(col2);
		t.getCaramelos()[c2.getFila()][c2.getColumna()].setColor(col1);
	}
	
	public static String colorCaramelo(Tablero t, Coordenada c){
		return t.getCaramelos()[c.getColumna()][c.getFila()].getColor();
	}
}
