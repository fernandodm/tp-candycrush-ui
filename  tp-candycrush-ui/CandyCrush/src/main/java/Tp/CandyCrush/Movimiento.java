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
	public abstract boolean esValido(Caramelo caramelo);
	public abstract void coordenadaMovimiento(int x, int y);
	public abstract void realizar(Caramelo caramelo) throws ExcepcionNoSePuedeMover;

}
