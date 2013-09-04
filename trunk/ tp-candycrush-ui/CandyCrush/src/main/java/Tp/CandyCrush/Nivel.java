package Tp.CandyCrush;

import java.util.List;

public class Nivel {
	private Dificultad dificultad;
	private Objetivo objetivo;
	

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	/**
	 * Retorna la cantidad de caramelos que pueden aparecer
	 * @return
	 */
	public int cantidadDeCaramelos() {
		
		return dificultad.getColores().size();
	}
	
	/**
	 * Retorna los colores de los caramelos que pueden aparecer en el nivel
	 * @return
	 */
	public List<String> caramelosDelNivel() {
		
		return dificultad.getColores();
	}

}
