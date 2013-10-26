package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Movimiento {
	private Tablero tablero;
	private String nombre;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	/**
	 * @param c
	 * @return devuelve la coordenada resultante al hacer el movimiento
	 */
	public abstract Coordenada coordenadaMovimiento(Coordenada c);
	

}
