package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Arriba extends Movimiento {

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	/*public void realizar(Coordenada c) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x-1, y);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}*/

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()-1, c.getColumna());
	}

}
