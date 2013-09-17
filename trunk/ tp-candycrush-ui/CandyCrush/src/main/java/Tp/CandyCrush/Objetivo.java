package Tp.CandyCrush;

public abstract class Objetivo {

	private boolean seCumplio;

	public boolean isSeCumplio() {
		return seCumplio;
	}

	public void setSeCumplio(boolean seCumplio) {
		this.seCumplio = seCumplio;
	}
	
	public abstract void actualizarObjetivo(Explosion exp);
	
}
