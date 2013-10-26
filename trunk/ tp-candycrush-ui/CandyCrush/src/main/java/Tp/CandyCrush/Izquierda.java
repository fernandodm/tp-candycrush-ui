package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Izquierda extends Movimiento {

	public Izquierda(){
		this.setNombre("Izquierda");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()-1);
	}

}