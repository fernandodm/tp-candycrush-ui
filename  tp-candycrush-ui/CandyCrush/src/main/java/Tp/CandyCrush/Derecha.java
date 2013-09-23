package Tp.CandyCrush;

public class Derecha extends Movimiento {

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()+1);
	}

}