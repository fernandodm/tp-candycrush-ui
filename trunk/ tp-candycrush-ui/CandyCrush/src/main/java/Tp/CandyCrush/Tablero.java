package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	//esto esta de prueba
	public Tablero() {
		Nivel nivel = new Nivel();
		nivel.setDificultad(Dificultad.DIFICIL);
		this.setUnNivel(nivel);
	}
	
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
	
	
	/**
	 * mueve el caramelo y si es valido el movimiento llama al metodo para 
	 * generar la explosion, caso contrario manda un mensaje de error
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCarameloSiEsValido(Coordenada c, Movimiento movimiento){
		Coordenada vecino= movimiento.coordenadaMovimiento(c);
		if(this.incluidoEnTablero(vecino) && !Caramelo.sonDelMismoColor(this, c, vecino))
		{
			Caramelo.swapCaramelos(this, c, vecino);
			this.chequearYExplotar(c, vecino);
		}
		else
		{	
			//TODO SystemOut mensajeMoviemientoInvalido
		}
	}

	/**
	 * si los caramelos en las coordenadas generan explosion se llama a los
	 * metodos que propagan las explosiones, bajan los caramelos y recursionan
	 * buscando mas explosiones; caso contrario los caramelos vuelven a su
	 * posición original y se manda un mensaje de error
	 * @param c
	 * @param vecino
	 */
	private void chequearYExplotar(Coordenada c, Coordenada vecino) {
		boolean huboExplosionEnC = Explosion.generoExplosion(this, c); 
		boolean huboExplosionEnVecino = Explosion.generoExplosion(this, vecino);
		if(huboExplosionEnC || huboExplosionEnVecino){
		Explosion.bajarCaramelos(this);
		Explosion.explosionesEnCadena(this);
		}
		else{
			Caramelo.swapCaramelos(this, c, vecino);
			//TODO SystemOut mensajeMovimiento sinExplosiones
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
	
    /**
     * @param c
     * @return devuelve true si la coordenada c esta contenida en el tablero
     */
	public boolean incluidoEnTablero(Coordenada c){
		return (c.getFila() >= 0 && c.getFila() <= this.getAlto()) && 
			   (c.getColumna() >= 0 && c.getColumna() <= this.getAncho());
	}
	
	public List<Dificultad> getDificultades() {
		return Dificultad.getDificultades();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}



