package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private List<Caramelo> caramelos = new ArrayList<Caramelo>();
	
	/**
	 * mueve el caramelo si es valido el movimeinto
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCaramelo(int x, int y, Movimiento mov){
		
		for(Caramelo each : caramelos){
			if(each.getX() == x && each.getY() == y){
				if(mov.esValido(each)){
					each.mover(mov);
				}
			}
		}
		
	}
	
	/**
	 * Verifica si hay explosiones alrededor de las coordenadas (x,y)
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public boolean hayExplosiones(int x, int y, String color){
																							
		hayDosCaramelosArriba(x,y,color);
		hayDosCaramelosAbajo(x,y,color);
		hayDosCaramelosIzquierda(x,y,color);
		hayDosCaramelosDerecha(x,y,color);
		hayDosCaramelosEnLosCostados(x,y,color);
		return true;
	}
	
	/**
	 * Verifica si hay dos caramelos arriba para ver si puede haber una explosion
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean hayDosCaramelosArriba(int x, int y, String color) {
		
		if((y-1) != 0 && (y-2) != 0){
			
			return verificarCaramelosArriba(y-1, y-2, color);
		}
		return false;
	}

	/**
	 * Verifica si los dos caramelos que estan arriba 
	 * (n1 y n2) son de color "color"
	 * @param n1
	 * @param n2
	 * @param color
	 * @return
	 */
	private boolean verificarCaramelosArriba(int n1, int n2, String color) {
		
		for(Caramelo each : caramelos){
			if(each.getY() == n1 && each.getColor().equals(color)){
				return verificarSegundoCaramelo(n2,color);
			}
		}
		return false;
	}
	
	/**
	 * Verifica que el segundo color sea de color "color"
	 * para completar el metodo verificarCaramelosArriba(...)
	 * @param n
	 * @param color
	 * @return
	 */
	public boolean verificarSegundoCaramelo(int n, String color){
		
		for(Caramelo each : caramelos){
			if(each.getY() == n && each.getColor().equals(color)){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
