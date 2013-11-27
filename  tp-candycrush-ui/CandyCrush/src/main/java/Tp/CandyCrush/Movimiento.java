package Tp.CandyCrush;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Movimiento implements Serializable{
	
	public static final Movimiento ARRIBA = new Arriba();
	public static final Movimiento ABAJO = new Abajo();
	public static final Movimiento IZQUIERDA = new Izquierda();
	public static final Movimiento DERECHA = new Derecha();
	
	private Tablero tablero;
	private String nombre;
	
	public static List<Movimiento> getMovimientos(){
		return Arrays.asList(ARRIBA, ABAJO, IZQUIERDA, DERECHA);
	}
	
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
