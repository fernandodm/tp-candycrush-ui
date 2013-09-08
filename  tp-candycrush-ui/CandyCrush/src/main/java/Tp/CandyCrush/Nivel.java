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

	public Caramelo carameloAleatorio() {
		
		String colorCaramelo = dificultad.colorCaramelo();
		
		return new Caramelo(colorCaramelo);
		
	}

}
