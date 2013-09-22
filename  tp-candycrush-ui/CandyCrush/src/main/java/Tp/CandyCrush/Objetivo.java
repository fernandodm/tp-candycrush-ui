package Tp.CandyCrush;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Objetivo {

	private boolean seCumplio;
	private String color;

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isSeCumplio() {
		return seCumplio;
	}

	public void setSeCumplio(boolean seCumplio) {
		this.seCumplio = seCumplio;
	}
	
	public abstract void actualizarObjetivo(Explosion exp);

	public abstract String getDescripcion();
	
}
