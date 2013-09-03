package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Abajo extends Movimiento {

	/**
	 * verifica si es valido el movimiento hacia abajo
	 */
	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return (caramelo.getY() + 1 <= this.getTablero().getAlto());
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) throws ExcepcionNoSePuedeMover {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX(), caramelo.getY() + 1);
			caramelo.swapPosicionesCon(getTablero().getCaramelos()[caramelo.getX()][caramelo.getY() + 1]);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

}