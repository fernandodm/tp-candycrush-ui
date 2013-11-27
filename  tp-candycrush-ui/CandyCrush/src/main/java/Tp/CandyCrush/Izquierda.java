package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Izquierda extends Movimiento implements Serializable{

	public Izquierda(){
		this.setNombre("Izquierda");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()-1);
	}

}