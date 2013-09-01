package Tp.CandyCrush;

public class Caramelo {
	private String color;
	
	public Caramelo(String color){
		

		this.color = color;
	}
		
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public void mover(Movimiento mov){
		
		mov.realizar(this);
		
	}
}
