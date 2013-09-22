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
	
	/**
	 * Propaga la explosión hacia mov y actualiza los caramelos explotados y el
	 * objeto explosión
	 */
	public void propagarHacia(Tablero t, Coordenada c, Explosion exp, 
			List<Coordenada> car, Movimiento mov){
		Coordenada vecino = mov.coordenadaMovimiento(c);
		String color = Caramelo.colorCaramelo(t, c);
		while(t.incluidoEnTablero(vecino) && Caramelo.colorCaramelo(t, vecino).equals(color)){
			exp.setCantidad(exp.getCantidad() + 1);
			car.add(vecino);
			vecino = mov.coordenadaMovimiento(vecino);
		}
	}
	
	public void notificarExplosion(Explosion exp){
		//TODO este metodo manda a los objetivos una nueva explosion
	}
}
