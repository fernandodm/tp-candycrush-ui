package Tp.CandyCrush;

import java.util.List;

public abstract class TipoDeExplosion {
	
	public abstract void propagarExplosion(Tablero t, Coordenada c);
	
	/**
	 * "explota" los caramelos de la lista es decir pone su color en "vacio"
	 * @param t
	 * @param cor
	 */
	public void explotarCaramelos(Tablero t, List<Coordenada> cor){
		for(Coordenada each : cor){
		t.getCaramelos()[each.getFila()][each.getColumna()].setColor("vacio");
		}
	}
	
	public void propagarHacia(Tablero t, Coordenada c, Explosion exp, 
			List<Coordenada> car, Movimiento mov){
		
	}
	public void notificarExplosion(Explosion exp){
		//TODO este metodo manda a los objetivos una nueva explosion
	}
}
