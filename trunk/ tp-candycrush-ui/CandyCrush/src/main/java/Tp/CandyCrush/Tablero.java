package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
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
		alto = filas;
		ancho = columnas;
		for(int x = 0; x < filas; x++){
			for(int y = 0; y < columnas; y++){
				Caramelo caramelo = carameloAleatorio(unNivel);
				caramelo.setX(x);
				caramelo.setY(y);
				caramelos[x][y] = caramelo;
			}
		}
	}
	
	/**
	 * Retorna un caramelo aleatorio de losposibles caramelos que
	 * puede haber en el nivel
	 * @param unNivel
	 * @return
	 */
	public Caramelo carameloAleatorio(Nivel unNivel){
		
		int num = (int) (Math.random() * (unNivel.cantidadDeCaramelos())); 
		String colorCaramelo = unNivel.caramelosDelNivel().get(num);
		Caramelo caramelo = new Caramelo(colorCaramelo);
		
		return caramelo;
	}
	
	public void swapCaramelos(int x1, int y1, int x2, int y2){
		Caramelo aux = this.getCaramelos()[x1][y1];
		this.getCaramelos()[x1][y1] = this.getCaramelos()[x2][y2]; 
		this.getCaramelos()[x2][y2] = aux;
	}
	
	public Caramelo carameloVecinoDe(Movimiento mov, int x, int y){
		
	}
	
	/**
	 * mueve el caramelo si es valido el movimeinto
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCaramelo(int x, int y, Movimiento movimiento){
		//los moviemientos deberian saber si son verticales u horizontales para simplificar los chequeos
		for(int x1 = 0; x1 < alto; x++){
			for(int y1 = 0; y1 < ancho; y++){
				if(x == x1 & y == y1){
					movimiento.realizar(x,y);
				}
			}
		if(esValidoElMovimiento(x,y,movimiento))
		//aca se deberia chequear que los caramelos a intercambiar sean de un color diferente
		//y si generaron explosion
		{
			caramelos[x][y]
		// no entiendo mucho el codigo aca pongo lo q se deberia hacer si el movimiento			
		// genero explosion
			this.propagarExplosion(x, y);
			this.propagarExplosion(vecino);
			this.bajarCaramelos();
			this.explosionesEnCadena();
		}
		else{
		// aca se manda mje de erro tanto si eran caramelos iguales, si se salian de los 
		// o si no genero explosion el moviemiento	
			
			//SystemOut mensajeMoviemientoInvalido
		}
		
	}
		
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(4);
	}

}
