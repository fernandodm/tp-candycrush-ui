package Tp.CandyCrush;

import excepciones.ExcepcionNoSePuedeMover;

public class Abajo extends Movimiento {



   /**
	 * realiza el movimiento
	 * @throws ExcepcionNoSePuedeMover 
	 * 
	 */
	/*
	public void realizar(int x, int y) throws ExcepcionNoSePuedeMover {
		if(this.esValido(x,y)){
			this.getTablero().swapCaramelos(x, y, x+1, y);
			} else {
				throw new ExcepcionNoSePuedeMover();
			}
	}
	*/
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()+1, c.getColumna());
	}

}