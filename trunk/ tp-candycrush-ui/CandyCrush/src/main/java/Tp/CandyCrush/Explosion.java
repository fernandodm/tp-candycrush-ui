package Tp.CandyCrush;

import java.util.*;

public class Explosion {

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
    
    private static void bajarCaramelos(Tablero t) {
		// TODO Auto-generated method stub
		
	}

	private static void propagarExplosion(Tablero t, int x1, int y1,
			Movimiento mov1, Movimiento mov2) {
		// TODO Auto-generated method stub	
	}

	/**
     * @param x
     * @param y
     * @return true si se generó una explosión en la posición x y     
     * */
    
	private static boolean explotaVertical(Tablero t, int x, int y) {
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
		
		return  explosionHacia(t, x, y, arriba1, arriba2) ||
				explosionHacia(t, x, y, abajo1, abajo2) ||
				explosionHacia(t, x, y, arriba1, abajo1) ;
	}
	
	private static boolean explotaHorizontal(Tablero t, int x, int y) {
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
		
		return  explosionHacia(t, x, y, izq1, izq2) ||
				explosionHacia(t, x, y, der1, der2) ||
				explosionHacia(t, x, y, izq1, der1) ;
	}
	
	private static boolean explosionHacia(Tablero t, int x, int y, List<Movimiento> vecino1, List<Movimiento> vecino2){
		String colorOriginal= t.getCaramelos()[x][y].getColor();
		String colorVecino1= t.colorCarameloEn(t, x, y, vecino1);
		String colorVecino2= t.colorCarameloEn(t, x, y, vecino2);
		return (colorOriginal == colorVecino1) && (colorOriginal == colorVecino2);
	}
	
	
}
