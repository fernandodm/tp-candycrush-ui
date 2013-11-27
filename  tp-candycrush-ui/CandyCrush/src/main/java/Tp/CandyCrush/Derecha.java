package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Derecha extends Movimiento implements Serializable{

	public Derecha(){
		this.setNombre("Derecha");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()+1);
	}

}