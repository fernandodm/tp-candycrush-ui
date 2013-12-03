package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public class Partida implements Serializable{
	
	private Integer puntaje;
	private Integer cantMovimientosFaltantes;
	private Mundo mundo;
	private Nivel nivelActual;
	private Coordenada coordenadaActual;
	public Movimiento movimientoARealizar;
	
	
	
	public Coordenada getCoordenadaActual() {
		return coordenadaActual;
	}

	public void setCoordenadaActual(Coordenada coordenadaActual) {
		this.coordenadaActual = coordenadaActual;
	}

	public Movimiento getMovimientoARealizar() {
		return movimientoARealizar;
	}

	public void setMovimientoARealizar(Movimiento movimientoARealizar) {
		this.movimientoARealizar = movimientoARealizar;
	}

	public Nivel getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(Nivel nivelActual) {
		this.nivelActual = nivelActual;
	}

	public Partida(Mundo mund){
		
		this.mundo = mund;
		this.setPuntaje(0);
		this.setCoordenadaActual(new Coordenada(0,0));
	} 	
	public Integer getPuntaje() {
		//return this.getPuntaje();
		return this.getNivelActual().getPuntaje();
	}
	public void setPuntaje(Integer puntajeFaltante) {
		this.puntaje = puntajeFaltante;
	}
	public Integer getCantMovimientosFaltantes() {
		return cantMovimientosFaltantes;
	}
	public void setCantMovimientosFaltantes(Integer cantMovimientosFaltantes) {
		this.cantMovimientosFaltantes = cantMovimientosFaltantes;
	}
	public Mundo getMundo() {
		return mundo;
	}
	public void setMundo(Mundo mundo) {
		this.mundo = mundo;
	}	

	public void pasarNivel(){
		int index = this.getMundo().getNiveles().indexOf(this.getNivelActual());
		this.setNivelActual(this.getMundo().getNiveles().get(index + 1));
	}

	public Object puntajeDelNivelActual() {
		
		return getNivelActual().getPuntajeMinimo();
	}
}

