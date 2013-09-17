package Tp.CandyCrush;

import java.util.*;

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

	public Explosion(int cant, String color){
		this.setCantidad(cant);
		this.setColor(color);
	}
	/**
	 * Busca explosiones en todo el tablero y si encuentra una propaga la explosi�n,
	 * baja los caramelos y hace una llamada recursiva
	 */
    public static void explosionesEnCadena(Tablero t){
    	boolean ver;
    	boolean hor;
		for(int x1 = 0; x1 < t.getAlto(); x1++){
			for(int y1 = 0; y1 < t.getAncho(); y1++){
				ver= explotaVertical(t, x1, y1);
				hor= explotaHorizontal(t, x1, y1);
				if(ver){
					propagarExplosion(t, x1, y1, new Arriba(), new Abajo());
				}
				if(hor){
					propagarExplosion(t, x1, y1, new Izquierda(), new Derecha());		
				}
				if(ver || hor){
					bajarCaramelos(t);
					explosionesEnCadena(t);
				}
			}
         }
    }
    
    /**
     * Baja los caramelos en todo el tablero
     * @param t
     */
    public static void bajarCaramelos(Tablero t) {
		for(int i=0; i < t.getAncho(); i++){
			Explosion.bajarCaramelosEnColumna(t, i);
		}
	}
    
    /**
     * Baja los caramelos en la columna dada
     * @param t
     * @param columna
     */
    public static void bajarCaramelosEnColumna(Tablero t, int columna){
    	Coordenada c = new Coordenada(0, columna);
    	Movimiento arriba= new Arriba();
    	for(int i= t.getAlto()-1; i < 0; i--){
    		Explosion.bajarCarameloEnCoordenada(t, c);
    		c= arriba.coordenadaMovimiento(c);
    	}
    }

    public static void bajarCarameloEnCoordenada(Tablero t, Coordenada c){
    	if(t.getCaramelos()[c.getFila()][c.getColumna()].getColor() == "vacio"){
    		Explosion.intercambiarConVecinoMasProximo(t, c);
    	}
    }
    
    public static void intercambiarConVecinoMasProximo(Tablero t, Coordenada c){
    	
    }
    
	public static void propagarExplosion(Tablero t, int x1, int y1,
			Movimiento mov1, Movimiento mov2) {
		// TODO Auto-generated method stub	
	}
	
	public void explotarCaramelo(Tablero t, Coordenada c){
		t.getCaramelos()[c.getFila()][c.getColumna()].setColor("vacio");
	}

	/**
     * @param x
     * @param y
     * @return true si se generó una explosión en la posición x y     
     * */
	
	
	public static boolean explotaVertical(Tablero t, Coordenada c) {
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
		
		return  explosionHacia(t, c, arriba1, arriba2) ||
				explosionHacia(t, c, abajo1, abajo2) ||
				explosionHacia(t, c, arriba1, abajo1) ;
	}
	
	public static boolean explotaHorizontal(Tablero t, Coordenada c) {
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
		
		return  explosionHacia(t, c, izq1, izq2) ||
				explosionHacia(t, c, der1, der2) ||
				explosionHacia(t, c, izq1, der1) ;
	}
	
	public static boolean explosionHacia(Tablero t, Coordenada c, List<Movimiento> vecino1, List<Movimiento> vecino2){
		String colorOriginal= t.getCaramelos()[c.getFila()][c.getColumna()].getColor();
		String colorVecino1= t.colorCarameloEn(t, c, vecino1);
		String colorVecino2= t.colorCarameloEn(t, c, vecino2);
		return (colorOriginal == colorVecino1) && (colorOriginal == colorVecino2);
	}
	
	
}
