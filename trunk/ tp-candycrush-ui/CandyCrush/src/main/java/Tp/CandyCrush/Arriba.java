package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Arriba extends Movimiento {

	/**
	 * verifica si es valido el movimiento hacia arriba
	 */
	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return (caramelo.getY() - 1 > 0);
	}

	/**
	 * realiza el movimiento
	 * NOTA FALTA ELIMINAR EL QUE ESTABA
	 * @throws ExcepcionNoSePuedeMover 
	 */
	@Override
	public void realizar(Caramelo caramelo) throws ExcepcionNoSePuedeMover {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo,this.getTablero().getCaramelos()[caramelo.getX()][caramelo.getY() - 1]);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}
	
	public static void main(String[] args) {
	
	}

}
