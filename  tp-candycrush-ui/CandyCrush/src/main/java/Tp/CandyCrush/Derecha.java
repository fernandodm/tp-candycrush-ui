package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Derecha extends Movimiento {

	public Derecha(){
		this.setNombre("Derecha");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila(), c.getColumna()+1);
	}

}