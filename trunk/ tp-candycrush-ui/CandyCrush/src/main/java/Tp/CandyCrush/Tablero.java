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
				Caramelo caramelo = carameloAleatorio(unNivel);
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
	 * @param y
	 * @param vecino1
	 * @return devuelve el color del caramelo en la posición a la que se llega siguiendo
	 * la lista de movimientos. Si la posición se sale del tablero devuelve "".

	 */

    public void explosionesEnCadena(){
    	Caramelo[][] actual= this[1][1];
		for(int x1 = 0; x1 < alto; x++){
			for(int y1 = 0; y1 < ancho; y++){
				if(generaExplosion(x1, y1)){
					this.propagarExplosion(x1, y1);
					this.bajarCaramelos();
					this.explosionesEnCadena();
				}
			}
    	 
         }
    }
  
    public String colorCarameloEn(Tablero t, int x, int y, List<Movimiento> vecino1) {
		String res = "";
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
	
	}

}



