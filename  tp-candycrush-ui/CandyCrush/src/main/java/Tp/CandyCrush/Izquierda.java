package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Izquierda extends Movimiento {


	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	/*
	public void realizar(int x, int y) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x, y - 1);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}
	*/

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()-1);
	}

}