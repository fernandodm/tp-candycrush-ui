package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Arriba extends Movimiento {

	
	
	public Arriba(){
		this.setNombre("Arriba");
	}
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()-1, c.getColumna());
	}

}
