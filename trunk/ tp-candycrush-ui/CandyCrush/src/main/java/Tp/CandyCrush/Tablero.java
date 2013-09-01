package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	private int alto;
	private int ancho;
	private Caramelo[][] caramelos;
	
	public Caramelo[][] getCaramelos() {
		return caramelos;
	}
	public void setCaramelos(Caramelo[][] carameloss) {
		this.caramelos = carameloss;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int x) {
		this.alto = x;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int x) {
		this.ancho = x;
	}

	/**
	 * Inicia el tablero con los caramelos
	 * @param filas
	 * @param columnas
	 * @param unNivel
	 */
	public void iniciar(int filas,int columnas, Nivel unNivel){
		
		caramelos = new Caramelo[filas][columnas];
		
		for(int x = 0; x < filas; x++){
			for(int y = 0; y < columnas; y++){
				Caramelo caramelo = carameloAleatorio(unNivel);
				caramelos[x][y] = caramelo;
			}
		}
	}
	
	public Caramelo carameloAleatorio(Nivel unNivel){
		
		int num = (int) (Math.random() * (unNivel.cantidadDeCaramelos())); 
		String colorCaramelo = unNivel.caramelosDelNivel().get(num);
		Caramelo caramelo = new Caramelo(colorCaramelo);
		
		return caramelo;
	}
	
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
	 Caramelo[][] n = new Caramelo[2][3];
	 System.out.println(n[0][0]);
	}

}
