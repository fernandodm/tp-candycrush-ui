package Tp.CandyCrush;

import java.io.Serializable;
import java.util.List;

public abstract class TipoDeExplosion implements Serializable{
	
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
			int cant = exp.getCantidad();
			exp.setCantidad(cant + 1);
			car.add(vecino);
			Coordenada cor = mov.coordenadaMovimiento(vecino);
			vecino = cor;
		}
	}
	
	public void notificarExplosion(Explosion exp, List<Coordenada> car, Tablero t){
		for(Objetivo each : t.getNivel().getObjetivos()){
			each.actualizarObjetivo(exp);
		}
		int puntosGanados = exp.getCantidad() * 10;
		int puntaje = t.getNivel().getPuntaje();
		t.getNivel().setPuntaje(puntaje + puntosGanados);
		t.getExplosionesARevisar().add(car);
	}
}
