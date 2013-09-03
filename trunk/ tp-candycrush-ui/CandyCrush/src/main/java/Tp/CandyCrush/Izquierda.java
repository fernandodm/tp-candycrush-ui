package Tp.CandyCrush;

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
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX() - 1, caramelo.getY());
			}
	}

}