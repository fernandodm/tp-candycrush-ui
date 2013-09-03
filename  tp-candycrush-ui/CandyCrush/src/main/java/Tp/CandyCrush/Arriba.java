package Tp.CandyCrush;

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
	 */
	@Override
	public void realizar(Caramelo caramelo) {
		if(this.esValido(caramelo)){
			this.getTablero().swapCaramelos(caramelo.getX(), caramelo.getY(), caramelo.getX(), caramelo.getY() + 1);
			}
	}
	
	public static void main(String[] args) {
	
	}

}
