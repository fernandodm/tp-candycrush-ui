package Tp.CandyCrush;

public class Caramelo {
	private String color;
	int x;
	int y;

	
	public Caramelo(String color){
		

		this.color = color;
	}
	
	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
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
