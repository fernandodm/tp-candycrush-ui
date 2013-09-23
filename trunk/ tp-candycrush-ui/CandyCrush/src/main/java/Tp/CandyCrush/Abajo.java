package Tp.CandyCrush;

public class Abajo extends Movimiento {

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()+1, c.getColumna());
	}

}