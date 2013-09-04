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
	
	public void swapCaramelos(Caramelo ca, Caramelo cb){
		Caramelo aux = this.getCaramelos()[ca.getX()][ca.getY()];
		int xAux = ca.getX();
		int yAux = ca.getY();
		
		this.getCaramelos()[ca.getX()][ca.getY()] = cb;
		this.getCaramelos()[cb.getX()][cb.getY()] = aux;
		
		this.getCaramelos()[ca.getX()][ca.getY()].setX(cb.getX());
		this.getCaramelos()[ca.getX()][ca.getY()].setY(cb.getY());
		
		this.getCaramelos()[cb.getX()][cb.getY()].setX(xAux);
		this.getCaramelos()[cb.getX()][cb.getY()].setX(yAux);
	}
	

	
	/**
	 * mueve el caramelo si es valido el movimeinto
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCaramelo(int x, int y, Movimiento movimiento){
		if(esValidoElMovimiento(x,y,movimiento))
		//aca se deberia chequear que los caramelos a intercambiar sean de un color diferente
		//y si generaron explosion
		{
		// no entiendo mucho el codigo aca pongo lo q se deberia hacer si el movimiento			
		// genero explosion
			//this.propagarExplosion(x, y);
			//this.propagarExplosion(vecino);
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
	 * @param x
	 * @param y
	 * @param vecino1
	 * @return devuelve el color del caramelo en la posición a la que se llega siguiendo
	 * la lista de movimientos. Si la posición se sale del tablero devuelve "error".
	 */
	public String colorCarameloEn(Tablero t, int x, int y, List<Movimiento> vecino1) {
		String res= "error";
		int x1= x;
		int y1= y;
		for(Movimiento each: vecino1){
			each.coordenadaMovimiento(x1, y1);
		}
		if(this.incluidoEnTablero(x1, y1)){
			res= t.getCaramelos()[x1][y1].getColor();
		}
		return res;
	}
	
	public boolean incluidoEnTablero(int x, int y){
		return (x >= 0 && x <= this.getAlto()) && (y >= 0 && y <= this.getAncho());
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(4);
	}

}
