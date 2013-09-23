package Tp.CandyCrush;


import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Explosion {

	private int cantidad;
	private String color;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * constructor utilizado para llamar a los mensajes de la clase explosion
	 * en los métodos del tablero
	 */
	public Explosion(){
	}
	
	/**
	 * constructor de la clase, dicho objeto es el que se manda al nivel
	 * para que actualize los objetivos
	 * @param cant
	 * @param color
	 */
	public Explosion(int cant, String color){
		this.setCantidad(cant);
		this.setColor(color);
	}
	
	/**
	 * Busca explosiones en todo el tablero y si encuentra una propaga la explosi�n,
	 * baja los caramelos y hace una llamada recursiva
	 */
    public void explosionesEnCadena(Tablero t){
		for(int x1 = 0; x1 < t.getAlto(); x1++){
			for(int y1 = 0; y1 < t.getAncho(); y1++){
				Coordenada c= new Coordenada(x1, y1);
				if(this.generoExplosion(t, c)){
					this.bajarCaramelos(t);
					this.explosionesEnCadena(t);
				}
			}
         }
    }
    
    /**
     * Baja los caramelos en todo el tablero
     * @param t
     */
    public void bajarCaramelos(Tablero t) {
		for(int i=0; i < t.getAncho(); i++){
			this.bajarCaramelosEnColumna(t, i);
		}
	}
    
    /**
     * Baja los caramelos en la columna dada
     * @param t
     * @param columna
     */
    public void bajarCaramelosEnColumna(Tablero t, int columna){
    	Coordenada c = new Coordenada(t.getAlto(), columna);
    	Movimiento arriba= new Arriba();
    	for(int i= t.getAlto()-1; i < 0; i--){
    		this.bajarCarameloEnCoordenada(t, c);
    		c= arriba.coordenadaMovimiento(c);
    	}
    }

    /**
     * Baja el caramelo o genera uno nuevo en una coordenada dada 
     * solo si esta estaba "vacia"
     * @param t
     * @param c
     */
    public void bajarCarameloEnCoordenada(Tablero t, Coordenada c){
    	if(t.getCaramelos()[c.getFila()][c.getColumna()].getColor().equals("vacio")){
    		this.bajarCarameloODameUnoNuevo(t, c);
    	}
    }
    
    /**
     * Hace un swap con en vecino mas proximo con caramelo o genera
     * uno aleatorio
     * @param t
     * @param c
     */
    private void bajarCarameloODameUnoNuevo(Tablero t, Coordenada c) {
    	if(! this.intercambioConVecino(t, c)){
    		this.dameUnCarameloNuevo(t, c);
    	}
	}

    /**
     * Busca el vecino con caramelo que tenga mas cerca y realiza el 
     * swap con la coordenada dada
     * @param t
     * @param c
     * @return dice si encontro un caramelo vecino con caramelo
     */
	public boolean intercambioConVecino(Tablero t, Coordenada c){
    	
    	Coordenada vecino= new Arriba().coordenadaMovimiento(c);
    	boolean loEncontre= false;
    	while(t.incluidoEnTablero(vecino) && !loEncontre){
    		if(! t.getCaramelos()[vecino.getFila()][vecino.getColumna()].getColor().equals("vacio")){
    			Caramelo.swapCaramelos(t, c, vecino);
    			loEncontre=true;
    		}
    		else{
    			new Arriba().coordenadaMovimiento(vecino);
    		}
    	}
    	return loEncontre;
    }
    
	/**
	 * Genera un caramelo aleatorio en la coordenada c
	 * @param t
	 * @param c
	 */
    public void dameUnCarameloNuevo(Tablero t, Coordenada c){
    	t.getCaramelos()[c.getFila()][c.getColumna()] = t.getNivel().carameloAleatorio();
    }
    
	/**
	 * @param t
	 * @param c
	 * @return devuelve si se genero una explosión en sentido vertical
	 * u horizontal dependiendo de los parametros
	 */
	public boolean explotaVertical(Tablero t, Coordenada c) {
		List<Movimiento> arriba1 = new ArrayList<Movimiento>();
		arriba1.add(new Arriba());
		List<Movimiento> arriba2 = new ArrayList<Movimiento>();
		arriba2.add(new Arriba());
		arriba2.add(new Arriba());
		List<Movimiento> abajo1 = new ArrayList<Movimiento>();
		abajo1.add(new Abajo());
		List<Movimiento> abajo2 = new ArrayList<Movimiento>();
		abajo2.add(new Abajo());
		abajo2.add(new Abajo());
		
		//List<Movimiento> m = Arrays.asList(new Arriba(),new Abajo());
		
		return  this.explosionHacia(t, c, arriba1, arriba2) ||
				this.explosionHacia(t, c, abajo1, abajo2) ||
				this.explosionHacia(t, c, arriba1, abajo1) ;
	}
	
	/**
	 * 
	 * @param t
	 * @param c
	 * @return
	 */
	public boolean explotaHorizontal(Tablero t, Coordenada c) {
		List<Movimiento> izq1 = new ArrayList<Movimiento>();
		izq1.add(new Izquierda());
		List<Movimiento> izq2 = new ArrayList<Movimiento>();
		izq2.add(new Izquierda());
		izq2.add(new Izquierda());
		List<Movimiento> der1 = new ArrayList<Movimiento>();
		der1.add(new Derecha());
		List<Movimiento> der2 = new ArrayList<Movimiento>();
		der2.add(new Derecha());
		der2.add(new Derecha());
		
		return  this.explosionHacia(t, c, izq1, izq2) ||
				this.explosionHacia(t, c, der1, der2) ||
				this.explosionHacia(t, c, izq1, der1) ;
	}
	
	/**
	 * @param t
	 * @param c
	 * @param vecino1
	 * @param vecino2
	 * @return true si el color del caramelo en c es el mismo que el de
	 * sus vecinos
	 */
	public boolean explosionHacia(Tablero t, Coordenada c, List<Movimiento> vecino1, List<Movimiento> vecino2){
		String colorOriginal= t.getCaramelos()[c.getFila()][c.getColumna()].getColor();
		String colorVecino1= t.colorCarameloEn(t, c, vecino1);
		String colorVecino2= t.colorCarameloEn(t, c, vecino2);
		return (colorOriginal.equals(colorVecino1)) && (colorOriginal.equals(colorVecino2));
	}

	/**
     * @param c
     * @return true si se generó una explosión en la coordenada c, si esto 
     * ocurro previamente se crea el tipo de explosión a propagar
     * y se llama al método que propaga dicha explosión     
     * */
	public boolean generoExplosion(Tablero t, Coordenada c) {
		boolean explotaVertical = this.explotaVertical(t, c);
		boolean explotaHorizontal = this.explotaHorizontal(t, c);
		if(explotaVertical || explotaHorizontal){
			TipoDeExplosion exp= this.tipoDeExplosion(explotaVertical, explotaHorizontal);
			exp.propagarExplosion(t, c);
		}
		return explotaVertical || explotaHorizontal;
	}
	
	/**
	 * @param v1
	 * @param v2
	 * @return el tipoDeExplosion correspondiente
	 */
	private TipoDeExplosion tipoDeExplosion(boolean v1, boolean v2) {
		TipoDeExplosion exp= new ExplosionHorizontal();
		if(v1&&v2){
			exp = new ExplosionEnCruz(); 
		}
		else{
			if(v2){
				exp = new ExplosionVertical();
			}
		}
		return exp;
	}
}
