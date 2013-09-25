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
    public Tablero explosionesEnCadena(Tablero t){
		for(int x1 = 0; x1 < t.getAlto(); x1++){
			for(int y1 = 0; y1 < t.getAncho(); y1++){
				Coordenada c= new Coordenada(x1, y1);
				if(this.generoExplosion(t, c)){
					t = t.bajarCaramelos();
					t = this.explosionesEnCadena(t);
				}
			}
         }
		return t;
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
		arriba2.add(new Arriba()); arriba2.add(new Arriba());
		List<Movimiento> abajo1 = new ArrayList<Movimiento>();
		abajo1.add(new Abajo());
		List<Movimiento> abajo2 = new ArrayList<Movimiento>();
		abajo2.add(new Abajo()); abajo2.add(new Abajo());
		
		Coordenada arr = c.coordenadaResultante(arriba1);
		Coordenada arrArr = c.coordenadaResultante(arriba2);
		Coordenada aba = c.coordenadaResultante(abajo1);
		Coordenada abaAba = c.coordenadaResultante(abajo2);
		
		return  this.explosionHacia(t, c, arr, arrArr) ||
				this.explosionHacia(t, c, aba, abaAba) ||
				this.explosionHacia(t, c, arr, aba) ;
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
		izq2.add(new Izquierda()); izq2.add(new Izquierda());
		List<Movimiento> der1 = new ArrayList<Movimiento>();
		der1.add(new Derecha());
		List<Movimiento> der2 = new ArrayList<Movimiento>();
		der2.add(new Derecha()); der2.add(new Derecha());
		
		Coordenada izq = c.coordenadaResultante(izq1);
		Coordenada izqIzq = c.coordenadaResultante(izq2);
		Coordenada der = c.coordenadaResultante(der1);
		Coordenada derDer = c.coordenadaResultante(der2);
		
		return  this.explosionHacia(t, c, izq, izqIzq) ||
				this.explosionHacia(t, c, der, derDer) ||
				this.explosionHacia(t, c, izq, der) ;
	}
	
	/**
	 * @param t
	 * @param c
	 * @param vecino1
	 * @param vecino2
	 * @return true si el color del caramelo en c es el mismo que el de
	 * sus vecinos
	 */
	public boolean explosionHacia(Tablero t, Coordenada c, Coordenada vecino1, Coordenada vecino2){
		String colorOriginal= t.colorCarameloEn(c);
		String colorVecino1= t.colorCarameloEn(vecino1);
		String colorVecino2= t.colorCarameloEn(vecino2);
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
