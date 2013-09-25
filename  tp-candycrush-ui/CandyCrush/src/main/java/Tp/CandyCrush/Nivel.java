package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
public class Nivel {
	
	private Dificultad dificultad;
	private List<Objetivo> objetivos = new ArrayList<Objetivo>();
	private boolean termino;
	private int puntaje;
	private int puntajeMinimo;
	private int nroNivel;
	private Tablero tablero;
	private String nombre;
	private int cantidadMovimientos;
	
	public int getCantidadMovimientos() {
		return cantidadMovimientos;
	}

	public void setCantidadMovimientos(int cantidadMovimientos) {
		
		if(cantidadMovimientos < 1){
			UserException userException = new UserException("La cantidad de movimientos debe ser mayor a 0.");
		      throw userException;
		}
		
		this.cantidadMovimientos = cantidadMovimientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getPuntajeMinimo() {
		return puntajeMinimo;
	}
	
	public boolean perdio(){
		return (this.getCantidadMovimientos() < 0);
	}

	public void setPuntajeMinimo(int puntajeMinimo) {
		
		if(puntajeMinimo < 1){
			UserException userException = new UserException("El puntaje debe ser mayor a 0.");
		      throw userException;
		}
		
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
		nroNivel = GeneradorNroNivel.generar();
	}
	
	public Caramelo carameloAleatorio() {
		
		String colorCaramelo = dificultad.colorCaramelo();
		
		return new Caramelo(colorCaramelo);
		
	}
	
	public Nivel(Dificultad dif, int minimo, ArrayList<Objetivo> objetivos){
		this.setDificultad(dif);
		this.setObjetivos(objetivos);
		this.setPuntaje(0);
		this.setPuntajeMinimo(minimo);
		this.setTermino(false);
		nroNivel = GeneradorNroNivel.generar();
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
		this.complete();
		
	}



	public void agregarObjetivo(Objetivo objetivo) {
		this.objetivos.add(objetivo);
		
	}

	public void eliminarObjetivo(Objetivo objetivo) {
		objetivos.remove(objetivo);
	}

	

}
