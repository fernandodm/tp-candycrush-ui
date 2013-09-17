package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public abstract class Movimiento {
	private Tablero tablero;
	
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public abstract Coordenada coordenadaMovimiento(Coordenada c);
	public abstract void realizar(int x, int y) throws ExcepcionNoSePuedeMover;
	public abstract boolean esValido(int x, int y);

}
