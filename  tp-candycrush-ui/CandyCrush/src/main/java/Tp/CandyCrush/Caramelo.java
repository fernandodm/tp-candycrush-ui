package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

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
	
<<<<<<< .mine
	//estaria de mas
	public void swapPosicionesCon(Caramelo c){
		int xAux = this.getX();
		int yAux = this.getY();
		this.setX(c.getX());
		this.setY(c.getY());
		c.setX(xAux);
		c.setY(yAux);
	}
	
=======

>>>>>>> .r26
	public void mover(Movimiento mov) throws ExcepcionNoSePuedeMover{
		
		//mov.realizar(); QUE PONEMOS ACA?
		
	}
	
	
}
