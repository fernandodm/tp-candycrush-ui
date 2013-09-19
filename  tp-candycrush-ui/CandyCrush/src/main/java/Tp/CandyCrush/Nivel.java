package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
	
	private Dificultad dificultad;
	private List<Objetivo> objetivos = new ArrayList<Objetivo>();
	private boolean termino;
	private int puntaje;
	private int puntajeMinimo;
	private int nroNivel;
	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getPuntajeMinimo() {
		return puntajeMinimo;
	}

	public void setPuntajeMinimo(int puntajeMinimo) {
		this.puntajeMinimo = puntajeMinimo;
	}

	public boolean isTermino() {
		return termino;
	}

	public void setTermino(boolean termino) {
		this.termino = termino;
	}
	
	public List<Objetivo> getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}
	
	public int getNroNivel() {
		return nroNivel;
	}

	public void setNroNivel(int nroNivel) {
		this.nroNivel = nroNivel;
	}

	public Nivel(){
		
	}
	
	public Caramelo carameloAleatorio() {
		
		String colorCaramelo = dificultad.colorCaramelo();
		
		return new Caramelo(colorCaramelo);
		
	}
	
	public Nivel(Dificultad dif, int minimo, ArrayList<Objetivo> objetivos, int nroNivel){
		this.setDificultad(dif);
		this.setObjetivos(objetivos);
		this.setPuntaje(0);
		this.setPuntajeMinimo(minimo);
		this.setTermino(false);
		this.setNroNivel(nroNivel);
	}
	
	public boolean seCumplieronTodosLosObjetivos(){
		boolean seCumplieron = false;
		for(Objetivo each: this.getObjetivos()){
			if(each.isSeCumplio()){
				seCumplieron = true;
			} else{
				seCumplieron = false;
			}
		}
		return seCumplieron;
	}
	
	public void complete(){
		
		if(this.seCumplieronTodosLosObjetivos() && this.getPuntaje() >= this.getPuntajeMinimo()){
			this.setTermino(true);
		}
	}
	
	public void actualizarObjetivos(Explosion exp){
		
		for(Objetivo each : this.getObjetivos()){
			each.actualizarObjetivo(exp);
		}
		this.setPuntaje(this.getPuntaje() + (10 * exp.getCantidad()));
		
	}

	

}
