package Tp.CandyCrush;

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
	 * 
	 */
	@Override
	public void realizar(Caramelo caramelo) {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX(), caramelo.getY() + 1);
			}
	}

}