package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Tp.CandyCrush.Caramelo;
import Tp.CandyCrush.Movimiento;
import Tp.CandyCrush.Nivel;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import excepciones.ExcepcionNoGeneroExplosion;

@Observable
public class Tablero {
	private int alto;
	private int ancho;
	private Caramelo[][] caramelos;
	private Nivel nivel;
	
	
	public Tablero() {
		//esto esta de prueba
		/**Nivel nivel = new Nivel();
		nivel.setDificultad(Dificultad.DIFICIL);
		this.setUnNivel(nivel);*/
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
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
		
		if(x < 1){
			UserException userException = new UserException("El alto del tablero debe ser mayor a 0.");
		      throw userException;
		}
		
		this.alto = x;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int x) {
		
		if(x < 1){
			UserException userException = new UserException("El ancho del tablero debe ser mayor a 0.");
		      throw userException;
		}
		
		this.ancho = x;
	}

	public List<Dificultad> getDificultades() {
		return Dificultad.getDificultades();
	}
	
	/**
	 * Inicia el tablero con los caramelos
	 */
	public void iniciar(){
		
		caramelos = new Caramelo[alto][ancho];
		for(int x = 0; x < alto; x++){
			for(int y = 0; y < ancho; y++){
				Caramelo caramelo = nivel.carameloAleatorio();
				caramelos[x][y] = caramelo;
			}
		}
      //  Explosion exp = new Explosion();
      //  exp.explosionesEnCadena(this);
	}
	
	
	/**
	 * mueve el caramelo y si es valido el movimiento llama al metodo para 
	 * generar la explosion, caso contrario manda un mensaje de error
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCarameloSiEsValido(Coordenada c, Movimiento movimiento, Explosion exp) throws ExcepcionNoGeneroExplosion{
		Coordenada vecino= movimiento.coordenadaMovimiento(c);
		if(this.incluidoEnTablero(vecino) && !this.sonDelMismoColor(c, vecino))
		{
			this.swapCaramelos(c, vecino);
			this.chequearYExplotar(c, vecino, exp);
		}
		else
		{	
			throw new ExcepcionNoGeneroExplosion();
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
	private void chequearYExplotar(Coordenada c, Coordenada vecino, Explosion exp) throws ExcepcionNoGeneroExplosion{
		boolean huboExplosionEnC = exp.generoExplosion(this, c); 
		boolean huboExplosionEnVecino = exp.generoExplosion(this, vecino);
		if(huboExplosionEnC || huboExplosionEnVecino){
			this.bajarCaramelos();
			exp.explosionesEnCadena(this);
		}
		else{
			this.swapCaramelos(c, vecino);
			throw new ExcepcionNoGeneroExplosion();
		}
	
	}

	/**
	 * @return devuelve el color del caramelo en la posición a la que se llega siguiendo
	 * la lista de movimientos. Si la posición se sale del tablero devuelve " ".

	 */
    public String colorCarameloEn(Coordenada c) { 
		return (this.incluidoEnTablero(c))? 
				this.getCaramelos()[c.getFila()][c.getColumna()].getColor(): " ";
    }
	
    /**
     * @param c
     * @return devuelve true si la coordenada c esta contenida en el tablero
     */
	public boolean incluidoEnTablero(Coordenada c){
		return (c.getFila() >= 0 && c.getFila() < this.getAlto()) && 
			   (c.getColumna() >= 0 && c.getColumna() < this.getAncho());
	}
	
	/**
	 * @param c1
	 * @param c2
	 * @return dice si los caramelos en c1 y c2 son del mismo color
	 */
	public boolean sonDelMismoColor(Coordenada c1, Coordenada c2){
		return Caramelo.colorCaramelo(this, c1).equals(Caramelo.colorCaramelo(this, c2));
	}

	/**
	 * @param c1
	 * @param c2
	 * @return un tablero en donde se intercambiarion los caramelos de c1 y c2
	 */
	public Tablero swapCaramelos(Coordenada c1, Coordenada c2){
		Tablero t = this;
		String col1 = t.colorCarameloEn(c1);
		String col2 = t.colorCarameloEn(c2);
		t.getCaramelos()[c1.getFila()][c1.getColumna()].setColor(col2);
		t.getCaramelos()[c2.getFila()][c2.getColumna()].setColor(col1);
		return t;
	}
	
    /**
     * Baja los caramelos en todo el tablero
     * @param t
     */
    public Tablero bajarCaramelos() {
    	Tablero t = this;
		for(int i=0; i < t.getAncho(); i++){
			t.bajarCaramelosEnColumna(1);
		}
		return t;
	}
    
    /**
     * Baja los caramelos en la columna dada
     * @param t
     * @param columna
     */
    public Tablero bajarCaramelosEnColumna(int columna){
    	if(this.hayQueBajarCaramelos(columna)){
        	Tablero tab = this;
        	Coordenada c = new Coordenada(tab.getAlto()-1, columna);
        	Movimiento arriba= new Arriba();
        	while(tab.hayQueBajarCaramelos(columna)){
     		   if(! tab.hayCaramelo(c)){
     			   tab.bajarCarameloODameUnoNuevo(c);
     		   }
     		   c= arriba.coordenadaMovimiento(c);
        	}
    	return tab;
    	}
    	return this;
    }
    
    /**
     * Busca el vecino con caramelo que tenga mas cerca y realiza el 
     * swap con la coordenada dada si no habia ninguno llama al metodo que genera
     * un caramelo aleatorio en la coordenada c
     * @param t
     * @param c
     * @return un tablero en donde la coordenada c tiene un caramelo nuevo,
     * ya sea porque bajo un caramelo de arriba o se genero uno nuevo
     */
   public Tablero bajarCarameloODameUnoNuevo(Coordenada c){	
       Movimiento arriba = new Arriba();
 	   Coordenada cor= arriba.coordenadaMovimiento(c);
 	   Tablero t = this;
 	   while(t.incluidoEnTablero(cor)){
 		   if(t.hayCaramelo(cor)){
 			   return t.swapCaramelos(c, cor);
 		   }
		   cor = arriba.coordenadaMovimiento(cor);
 	   }
	   return t.dameUnCarameloAleatorio(c);
	  
   	}
	
   	/**
   	 * @param c
   	 * @return un tablero en donde se intercambiaron los caramelos de c y el 
   	 * vecino no vacio mas cercano
   	 */
  /* 	public Tablero intercambiarConVecino(Coordenada c){
 	   Movimiento arriba = new Arriba();
 	   Coordenada cor= arriba.coordenadaMovimiento(c);
 	   Tablero t = this;
 	   while(t.incluidoEnTablero(cor) && !t.hayCaramelo(cor)){
 			   cor = arriba.coordenadaMovimiento(cor);
 	   }
 	   return t.swapCaramelos(c, cor);
   	}*/
   	
	/**
	 * @param t
	 * @param c
	 * @return un tablero en donde se genero un caramelo nuevo donde estaba vacio
	 */
	public Tablero dameUnCarameloAleatorio(Coordenada c){
		Tablero t = this;
		Caramelo car = t.getNivel().carameloAleatorio();
		t.getCaramelos()[c.getFila()][c.getColumna()] = car;
		return t;
	}
	
    /**
     * @param columna
     * @return devuelve true si hay que bajar caramelos en la columna
     */
    public boolean hayQueBajarCaramelos(int columna){
       	Movimiento arriba= new Arriba();	
       	Coordenada c = new Coordenada(this.getAlto()-1, columna);
    	while(this.incluidoEnTablero(c)){
    		if(! this.hayCaramelo(c)){
    			return true;
    		}
    		c= arriba.coordenadaMovimiento(c);
    	}
    	return false;
    }
    
    /**
     * @param c
     * @return devuelve true si hay alguna casilla arriba de c para bajar caramelos
     */
    public boolean hayVecinoParaIntercambiar(Coordenada c){
       	Movimiento arriba= new Arriba();	
       	Coordenada c1 = arriba.coordenadaMovimiento(c);
    	while(this.incluidoEnTablero(c1)){
    		if(this.hayCaramelo(c1)){
    			return true;
    		}
    		c= arriba.coordenadaMovimiento(c);
    	}
    	return false;
    }
    
    /**
     * @param c
     * @return devuelve true si hay un caramelo en c
     */
    public boolean hayCaramelo(Coordenada c){
    	return ! this.colorCarameloEn(c).equals("vacio");
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}



