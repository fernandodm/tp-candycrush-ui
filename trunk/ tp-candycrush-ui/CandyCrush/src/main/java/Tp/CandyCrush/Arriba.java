package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Arriba extends Movimiento {

	/**
	 * verifica si es valido el movimiento hacia arriba
	 */
	@Override
	public boolean esValido(int x, int y) {
				
		return(x - 1 >= 0);
		
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(int x, int y) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x-1, y);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

	@Override
	public void coordenadaMovimiento(int x, int y){
		x++;
	}

}
