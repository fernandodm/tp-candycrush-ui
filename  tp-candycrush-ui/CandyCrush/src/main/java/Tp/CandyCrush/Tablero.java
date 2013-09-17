package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Movimiento;
import Tp.CandyCrush.Nivel;
import org.uqbar.commons.utils.Observable;

@Observable
public class Tablero {
	private int alto;
	private int ancho;
	private Caramelo[][] caramelos;
	private Nivel unNivel;
	
	public Nivel getUnNivel() {
		return unNivel;
	}
	public void setUnNivel(Nivel unNivel) {
		this.unNivel = unNivel;
	}
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
	public void iniciar(){
		
		caramelos = new Caramelo[alto][ancho];
		for(int x = 0; x < alto; x++){
			for(int y = 0; y < ancho; y++){
				Caramelo caramelo = unNivel.carameloAleatorio();
				caramelos[x][y] = caramelo;
			}
		}
	}
	
	public void swapCaramelos(int x1, int y1, int x2, int y2){
		Caramelo aux = this.getCaramelos()[x1][y1];
		this.getCaramelos()[x1][y1] = this.getCaramelos()[x2][y2];
		this.getCaramelos()[x2][y2] = aux;
	}
	

	
	/**
	 * mueve el caramelo si es valido el movimeinto
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCaramelo(int x, int y, Movimiento movimiento){
		int x1=x;
		int y1=y;
		movimiento.coordenadaMovimiento(x1, y1);
		if(this.incluidoEnTablero(x1, y1)) //chequear posibles explosiones
		{
			//swapear x y con x1 y1
			// REFACTORING!!!
			if(Explosion.explotaHorizontal(this, x, y))
			Explosion.propagarExplosion(this, x, y, new Arriba(), new Abajo());
			if(Explosion.explotaVertical(this, x, y))
			Explosion.propagarExplosion(this, x, y, new Izquierda(), new Derecha());
			
			if(Explosion.explotaHorizontal(this, x1, y1))
			Explosion.propagarExplosion(this, x1, y1, new Arriba(), new Abajo());
			if(Explosion.explotaVertical(this, x1, y1))
			Explosion.propagarExplosion(this, x1, y1, new Izquierda(), new Derecha());
			
			Explosion.bajarCaramelos(this);
			Explosion.explosionesEnCadena(this);
		}
		else{
		// aca se manda mje de erro tanto si eran caramelos iguales, si se salian de los 
		// o si no genero explosion el moviemiento	
			
			//SystemOut mensajeMoviemientoInvalido
		}
		
	}

	/**
	 * @param x
	 * @param y//
	 * @param vecino1
	 * @return devuelve el color del caramelo en la posición a la que se llega siguiendo
	 * la lista de movimientos. Si la posición se sale del tablero devuelve " ".

	 */
    public String colorCarameloEn(Tablero t, Coordenada c, List<Movimiento> mov) {
		Coordenada aux= Coordenada.coordenadaResultante(c, mov); 
		return (this.incluidoEnTablero(aux))? 
				t.getCaramelos()[aux.getColumna()][aux.getFila()].getColor(): " ";
	}
	
	public boolean incluidoEnTablero(Coordenada c){
		return (c.getFila() >= 0 && c.getFila() <= this.getAlto()) && (c.getColumna() >= 0 && c.getColumna() <= this.getAncho());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}



