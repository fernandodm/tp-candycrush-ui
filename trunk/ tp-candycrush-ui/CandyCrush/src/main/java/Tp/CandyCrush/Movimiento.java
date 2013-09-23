package Tp.CandyCrush;

public abstract class Movimiento {
	private Tablero tablero;
	
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
