package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public class Partida {
	
	private int puntaje;
	private int cantMovimientosFaltantes;
	private Mundo mundo;
	private Nivel nivelActual;
	private Caramelo[][] caramelos; // para la ventana
	
	public Nivel getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(Nivel nivelActual) {
		this.nivelActual = nivelActual;
	}

	public Partida(Mundo mund){
		
		this.mundo = mund;
		this.cantMovimientosFaltantes = mund.getNiveles().get(0).getCantidadMovimientos();
		this.puntaje = mund.getNiveles().get(0).getPuntajeMinimo();
		this.nivelActual = mund.getNiveles().get(0);
		nivelActual.getTablero().setAlto(4);
		nivelActual.getTablero().setAncho(4);
		nivelActual.getTablero().iniciar();
		this.caramelos = mund.getNiveles().get(0).getTablero().getCaramelos();
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

	public Caramelo[][] getCaramelos() {
		return caramelos;
	}

	public void setCaramelos(Caramelo[][] caramelos) {
		this.caramelos = caramelos;
	}
	
	
}
