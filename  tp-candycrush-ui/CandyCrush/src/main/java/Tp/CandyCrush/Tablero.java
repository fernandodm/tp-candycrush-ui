package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Movimiento;
import Tp.CandyCrush.Nivel;

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
	 * Busca explosiones en todo el tablero y si encuentra una propaga la explosi�n,
	 * baja los caramelos y hace una llamada recursiva
	 * @param x
	 * @param y
	 * @param vecino1
	 * @return devuelve el color del caramelo en la posición a la que se llega siguiendo
	 * la lista de movimientos. Si la posición se sale del tablero devuelve "error".

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
    
    public boolean puedeMover(int x, int y, Movimiento mov){
    	
    	return mov.esValido(x,y);
    }
		
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
