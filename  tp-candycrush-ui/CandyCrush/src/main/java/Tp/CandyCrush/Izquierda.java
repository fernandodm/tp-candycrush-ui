package Tp.CandyCrush;

public class Izquierda extends Movimiento {

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()-1);
	}

}