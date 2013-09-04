package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Izquierda extends Movimiento {


	/**
	 * verifica si es valido el movimiento hacia la izquierda
	 */
	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return (caramelo.getX() - 1 < 0);
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) throws ExcepcionNoSePuedeMover {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX() - 1, caramelo.getY());
			caramelo.swapPosicionesCon(getTablero().getCaramelos()[caramelo.getX() - 1][caramelo.getY()]);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

}