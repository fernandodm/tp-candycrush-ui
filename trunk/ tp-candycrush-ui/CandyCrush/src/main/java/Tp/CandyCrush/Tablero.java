package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private List<Caramelo> caramelos = new ArrayList<Caramelo>();
	
	public void moverCaramelo(int x, int y, Movimiento mov){
		
		for(Caramelo each : caramelos){
			if(each.getX() == x && each.getY() == y){
				if(mov.esValido(each)){
					each.mover(mov);
				}
			}
		}
		
	}
	
	// n representa el movimiento
	public boolean hayExplosiones(Caramelo caramelo, Movimiento movimiento){
		
		
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
