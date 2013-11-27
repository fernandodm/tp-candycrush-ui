package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Abajo extends Movimiento implements Serializable{

	public Abajo(){
		this.setNombre("Abajo");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()+1, c.getColumna());
	}

}