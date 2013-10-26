package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Abajo extends Movimiento {

	public Abajo(){
		this.setNombre("Abajo");
	}
	
	@Override
	public Coordenada coordenadaMovimiento(Coordenada c){
		return new Coordenada(c.getFila()+1, c.getColumna());
	}

}