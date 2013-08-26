package Tp.CandyCrush;

public class Arriba extends Movimiento {

	@Override
	public boolean esValido(Caramelo caramelo) {
				
		return ((caramelo.getY() - 1) == 0) && getTablero().hayExplosiones(caramelo, this);
	}

	@Override
	public void realizar(Caramelo caramelo) {
		
		caramelo.setY(caramelo.getY() - 1);
		
	}

}
