package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Derecha extends Movimiento {


	/**
	 * verifica si es valido el movimiento hacia la derecha
	 */
	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return (caramelo.getX() + 1 <= this.getTablero().getAncho());
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) throws ExcepcionNoSePuedeMover {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo,this.getTablero().getCaramelos()[caramelo.getX() + 1][caramelo.getY()]);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

}