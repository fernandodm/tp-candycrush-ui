package Tp.CandyCrush;


import java.io.Serializable;
import java.util.ArrayList;

import org.uqbar.commons.model.UserException;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import excepciones.ExcepcionNoGeneroExplosion;

@Observable

public class Tablero implements Serializable{

	private Integer alto;
	private Integer ancho;
	private Caramelo[][] caramelos; 
	private Nivel nivel;
	private boolean tabPuedeAgregar = false; 
	private List<List<Coordenada>> explosionesARevisar = new ArrayList<List<Coordenada>>();
	
	public Tablero(){
		
	}
		
	public Tablero(Integer alto2, Integer ancho2, Nivel nivel) {
		this.alto = alto2;
		this.ancho = ancho2;
		this.nivel = nivel;

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
	public Integer getAlto() {

		return alto;
	}
	
	public void setAlto(Integer x) {
		this.validarAlto(x);
		this.alto = x;		
	}
	public List<List<Coordenada>> getExplosionesARevisar() {
		return explosionesARevisar;
	}

	public void setExplosionesARevisar(List<List<Coordenada>> explosionesARevisar) {
		this.explosionesARevisar = explosionesARevisar;
	}

	
	public boolean getTabPuedeAgregar() {
		return tabPuedeAgregar;
	}


	public void setTabPuedeAgregar(boolean tabPuedeAgregar) {
		this.tabPuedeAgregar = tabPuedeAgregar;
	}


	public Integer getAncho() {
		return ancho;
	}
	public void setAncho(Integer x) {
		this.validarAncho(x);
		this.ancho = x;
	}

	public List<Dificultad> getDificultades() {
		return Dificultad.getDificultades();
	}

	public void validarAlto(Integer unAlto) {
		if (unAlto < 3) {
			throw new UserException("Altura mínima: 3");
		}
	}
	
	public void validarAncho(Integer unAncho) {
		if (unAncho < 3) {
			throw new UserException("Ancho mínimo: 3");
		}
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
       // Explosion exp = new Explosion();
     //   exp.explosionesEnCadena(this);
	}
	
	
	/**
	 * mueve el caramelo y si es valido el movimiento llama al metodo para 
	 * generar la explosion, caso contrario manda un mensaje de error
	 * @param x
	 * @param y
	 * @param mov
	 */
	public void moverCarameloSiEsValido(Coordenada c, Movimiento movimiento) throws ExcepcionNoGeneroExplosion{
		Coordenada vecino= movimiento.coordenadaMovimiento(c);
		Explosion exp = new Explosion();
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
	 * posiciÃ³n original y se manda un mensaje de error
	 * @param c
	 * @param vecino
	 */
	private void chequearYExplotar(Coordenada c, Coordenada vecino, Explosion exp) throws ExcepcionNoGeneroExplosion{
		boolean huboExplosionEnC = exp.generoExplosion(this, c); 
		boolean huboExplosionEnVecino = exp.generoExplosion(this, vecino);
		if(huboExplosionEnC || huboExplosionEnVecino){
			this.llenarHuecos();
			//exp.explosionesEnCadena(this);
		}
		else{
			this.swapCaramelos(c, vecino);
			throw new ExcepcionNoGeneroExplosion();
		}
	
	}

	public void llenarHuecos() {
		List<List<Coordenada>> huecos = this.getExplosionesARevisar();
		for(List<Coordenada> each: huecos){
			this.llenarEstaExplosion(each);
		}
		huecos.removeAll(huecos);
	}

	private void llenarEstaExplosion(List<Coordenada> explotadas) {
		for(Coordenada each: explotadas){
			String color = this.getNivel().carameloAleatorio().getColor();
			this.cambiarColorCaramelo(each, color);
		}
	}

	/**
	 * @return devuelve el color del caramelo en la posiciÃ³n a la que se llega siguiendo
	 * la lista de movimientos. Si la posiciÃ³n se sale del tablero devuelve " ".

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
		String col1 = this.colorCarameloEn(c1);
		String col2 = this.colorCarameloEn(c2);
		this.getCaramelos()[c1.getFila()][c1.getColumna()].setColor(col2);
		this.getCaramelos()[c2.getFila()][c2.getColumna()].setColor(col1);
		return this;
	}

	
    /**
     * Baja los caramelos en todo el tablero
     * @param t
//     */
//<<<<<<< .mine
//
//   /* public Tablero bajarCaramelos() {
//		Tablero t = this;
//    	for(int j = this.getAncho()-1 ; j <= 0; j--){	
//			t.bajarCaramelosEnColumna(j);
//=======
//=======
//   /* public Tablero bajarCaramelos() {
//		Tablero t = this;
//    	for(int j = this.getAncho()-1 ; j <= 0; j--){	
//			t.bajarCaramelosEnColumna(j);
//>>>>>>> .r107
//    public Tablero bajarCaramelos(List<Coordenada> cs) {
//		int[] col = Coordenada.columnasARevisar(cs);
//    	Tablero t = this;
//		for(int i=0; i < col.length-1; i++){	
//			t = t.bajarCaramelosEnColumna(col[i]);
//>>>>>>> .r100
//		}
//		return t;
//<<<<<<< .mine
//	}*/
////	public Tablero bajarCaramelos(){
////		Tablero t = this;
////		for(int x = t.getAlto()-1 ; x <= 0; x--){
////			for(int y = t.getAncho()-1; y <= 0; y--){
////				Coordenada cor = new Coordenada(x, y);
////				if(!t.hayCaramelo(cor)){
////					t.bajarLosDeArriba(cor);
////				}
////			}
////		}	
////		return t;
////	}
//	
//=======
//	}*/
//	public Tablero bajarCaramelos(){
//		Tablero t = this;
//		for(int x = t.getAlto()-1 ; x <= 0; x--){
//			for(int y = t.getAncho()-1; y <= 0; y--){
//				Coordenada cor = new Coordenada(x, y);
//				if(!t.hayCaramelo(cor)){
//				//	t.bajarLosDeArriba(cor);
//				}
//			}
//		}	
//		return t;
//	}
//>>>>>>> .r107
//	
//    


	public Tablero bajarCaramelos(){
		Tablero t = this;
		for(int x = t.getAlto()-1 ; x <= 0; x--){
			for(int y = t.getAncho()-1; y <= 0; y--){
				Coordenada cor = new Coordenada(x, y);
				if(!t.hayCaramelo(cor)){
				//	t.bajarLosDeArriba(cor);
				}
			}
		}	
		return t;
	}
	

   
    
    /**
     * @param columna
<<<<<<< .mine
     */
  /*  public Tablero bajarCaramelosEnColumna(int columna){
    	if(this.hayQueBajarCaramelos(columna)){
        	Tablero tab = this;
        	Coordenada c = new Coordenada(tab.getAlto()-1, columna);
        	Movimiento arriba= new Arriba();
        	if(tab.hayVecinoParaIntercambiar(c)){
        		while(tab.hayVecinoParaIntercambiar(c)){
        			tab.bajarLosDeArriba(c);
        			c= arriba.coordenadaMovimiento(c);
        		}
        		return tab.llenarConAleatorios(c);
        	}
        	else{
        		return tab.llenarConAleatorios(c);
        	}
        	}
    	return this;
    }*/
    
    /**
     * @param c
     * @return un tablero en donde se bajaron todos los caramelos arriba de c
     */
   /* public Tablero bajarLosDeArriba(Coordenada c){
    	Movimiento arriba = new Arriba();
   	    Coordenada cor= arriba.coordenadaMovimiento(c);
   	    while(this.incluidoEnTablero(cor)){
   		   if(this.hayCaramelo(cor)){
   			   this.swapCaramelos(c, cor);
   			   return this;
   		   }
  		   cor = arriba.coordenadaMovimiento(cor);
   	   }
<<<<<<< .mine
<<<<<<< .mine
  	   return t.dameUnCarameloAleatorio(c);
=======
=======
  	   return t.dameUnCarameloAleatorio(c);
>>>>>>> .r107
  	   return this;
    }*/
    
    /**
     * @param columna
=======
>>>>>>> .r108
     * @return un tablero en donde se bajaron los caramelos en la columna 
     */
    public Tablero bajarCaramelosEnColumna(int columna){
    	Tablero t = this;
    	String[] col = t.arrayDeColumna(columna);
    	col = this.dejarVaciosArriba(col);
    	//col = this.llenarConAleatorios(col);
    //	t.setCaramelos(t.reinsertarColumna(col, columna));
    	return t;

    }
    
    /** 
     * @param col
     * @param columna
     * @return baja los caramelos en la columna
     */
    public Caramelo[][] reinsertarColumna(List<String> col, int columna){
    	int tam = this.getAlto();
    	Caramelo[][] cars = this.getCaramelos();
    	int i = 0;
    	for(String each: col){
    		Coordenada c = new Coordenada(i, columna);
    		String color = each;
    	//	System.out.println(this.colorCarameloEn(c));
    	//	System.out.println(each);
    		this.cambiarColorCaramelo(c, color);
    	//	System.out.println(this.colorCarameloEn(c));
    		i++;
    	} 	
    	return cars;
    }
    
    /**
     * @param c
     * @param col
     * cambia el color del caramelo en c por el color col
     */
    public void cambiarColorCaramelo(Coordenada c, String col){
       	this.getCaramelos()[c.getFila()][c.getColumna()].setColor(col);
    }
    
    /**
     * @param columna
     * @return un array con los colores de los caramelos en la columna
     */
    public String[] arrayDeColumna(int columna){
    	String[] col = new String[this.getAlto()];
    	for(int i=0; i < col.length; i++){
    		col[i] = this.getCaramelos()[i][columna].getColor();
    	}
    	return col;
    }
    
    /**
     * @param col
     * @return un array de colores donde se "llenaron" los espacios vacios
     */
    public String[] llenarConAleatorios(String[] col){
    	int i = col.length - 1;
    	while(i>-1){
    		if(col[i].equals("vacio")){
    			String color = this.getNivel().carameloAleatorio().getColor();
    			col[i] = color;
    		}
    		i--;
    	}
    	return col;
    }
    
    /**
     * @param col
     * @return un array donde los vacios quedaron arriba
     */
    public String[] dejarVaciosArriba(String[] col){
    	int i = col.length - 1;
    	while(i>-1){
    		if(col[i].equals("vacio")){
    			col = this.traerVecinoA(col, i);
    		}
    		i--;
    	}
    	return this.llenarConAleatorios(col);
    }
    
    /**
     * @param col
     * @param celda
     * @return baja el vecino mas cercano no vacio a la posicion celda del array
     */
    public String[] traerVecinoA(String[] col, int celda) {
    	int vecino = celda-1;
    	while(vecino>-1)
    	{
			if(! col[vecino].equals("vacio")){
				col[celda] = col[vecino];
				col[vecino] = "vacio";
				return col;
			}
			vecino--;
		}
		return col;
	}
    
	/**
     * @param c
     * @return devuelve true si hay un caramelo en c
     */
    public boolean hayCaramelo(Coordenada c){
    	return ! this.colorCarameloEn(c).equals("vacio");
    }
    
    public List<Fila> filas(){
    	
    	List<Fila> filas = new ArrayList<Fila>();

    	for(int i = 0; i < this.getCaramelos().length ; i++){
    		Fila fila =  new Fila();
    		for(int j = 0; j < this.getCaramelos()[0].length ; j++){
    			fila.getCaramelos().add(this.getCaramelos()[i][j]);
    		}
    		filas.add(fila);
    	}
    	
    	return filas;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}



}



