package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Arriba extends Movimiento implements Serializable{

	
	
	public Arriba(){
		this.setNombre("Arriba");
	}
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()-1, c.getColumna());
	}

}
