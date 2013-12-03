package Tp.CandyCrush;


import java.io.Serializable;

import org.uqbar.commons.model.UserException;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Nivel implements Serializable{
	
	private Dificultad dificultad; 
	private List<Objetivo> objetivos = new ArrayList<Objetivo>();
	private boolean termino;
	private int puntaje;
	private Integer puntajeMinimo;
	private int nroNivel;
	private Tablero tablero = new Tablero();
	private String nombre;
	private Integer cantidadMovimientos;
	private boolean nivPuedeAgregar;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNivPuedeAgregar(boolean bool){
		this.nivPuedeAgregar = bool;
	}
	
	public boolean getNivPuedeAgregar(){
		return this.nivPuedeAgregar;
	}
	
	public Integer getCantidadMovimientos() {
		return cantidadMovimientos;
	}

	public void setCantidadMovimientos(Integer cantidadMovimientos) {		
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

	public Integer getPuntajeMinimo() {
		return puntajeMinimo;
	}
	
	public boolean perdio(){
		return (this.getCantidadMovimientos() < 0);
	}

	public void setPuntajeMinimo(Integer puntajeMinimo) {	
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
	
	public String descripcionEstado(){
		if(this.isTermino()){
			return "Completado!";
		} else {
			return "No completado";
		}
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
