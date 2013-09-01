package Tp.CandyCrush;

import java.util.List;

public class Nivel {
	private Dificultad dificultad;

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
