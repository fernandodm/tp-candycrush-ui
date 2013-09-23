package Tp.CandyCrush;

public class Arriba extends Movimiento {

	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()-1, c.getColumna());
	}

}
