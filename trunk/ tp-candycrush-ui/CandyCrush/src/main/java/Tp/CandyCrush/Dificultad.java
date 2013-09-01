package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public abstract class Dificultad {
	private List<String> colores = new ArrayList<String>();

	public List<String> getColores() {
		return colores;
	}

	public void setColores(List<String> colores) {
		this.colores = colores;
	}

}
