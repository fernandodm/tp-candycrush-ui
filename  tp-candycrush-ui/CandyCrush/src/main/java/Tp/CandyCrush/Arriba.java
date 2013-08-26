package Tp.CandyCrush;

public class Arriba extends Movimiento {

	/**
	 * verifica si es valido el movimiento hacia arriba
	 */
	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return ((caramelo.getY() - 1) != 0) && 
				getTablero().hayExplosiones(caramelo.getX(),caramelo.getY()-1, caramelo.getColor());
	}

	/**
	 * realiza el movimiento
	 * NOTA FALTA ELIMINAR EL QUE ESTABA
	 */
	@Override
	public void realizar(Caramelo caramelo) {
		
		caramelo.setY(caramelo.getY() - 1);
		
	}

}
