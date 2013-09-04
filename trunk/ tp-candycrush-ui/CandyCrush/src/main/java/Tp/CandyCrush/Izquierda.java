package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Izquierda extends Movimiento {


	/**
	 * verifica si es valido el movimiento hacia la izquierda
	 */
	@Override
	public boolean esValido(int x, int y) {
				
		return(y - 1 >= 0);
		
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(int x, int y) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x, y - 1);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

	@Override
	public void coordenadaMovimiento(int x, int y){
		x++;
	}

}