package Tp.CandyCrush;

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
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX() + 1, caramelo.getY());
			}
	}

}