package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Partida {
	
	private int puntaje;
	private int cantMovimientosFaltantes;
	private Mundo mundo;
	private Nivel nivelActual;
	
	public Nivel getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(Nivel nivelActual) {
		this.nivelActual = nivelActual;
	}

	public Partida(Mundo mund){
		
		this.mundo = mund;
	} 	
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntajeFaltante) {
		this.puntaje = puntajeFaltante;
	}
	public int getCantMovimientosFaltantes() {
		return cantMovimientosFaltantes;
	}
	public void setCantMovimientosFaltantes(int cantMovimientosFaltantes) {
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
}
