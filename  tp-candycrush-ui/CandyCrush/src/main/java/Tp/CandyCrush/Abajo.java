package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Abajo extends Movimiento {

	/**
	 * verifica si es valido el movimiento hacia abajo
	 */
	@Override
	public boolean esValido(int x, int y) {
				
		return(x + 1 < this.getTablero().getAlto());
		
	}

	/**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	@Override
	public void realizar(int x, int y) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x+1, y);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()+1, c.getColumna());
	}

}