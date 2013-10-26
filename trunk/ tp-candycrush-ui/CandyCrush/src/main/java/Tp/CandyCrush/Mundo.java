package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Mundo {
	private List<Nivel> niveles = new ArrayList<Nivel>();
	private int nivelActual;
	private int cantidadNiveles;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivelActual() {
		return nivelActual;
	}
	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}
	public List<Nivel> getNiveles() {
		return niveles;
	}
	public void setNiveles(List<Nivel> niveles) {
		this.niveles = niveles;
	}
	public int getCantidadNiveles() {
		return cantidadNiveles;
	}
	public void setCantidadNiveles(int cantidadNiveles) {
		this.cantidadNiveles = cantidadNiveles;
	}
		
	public void pasarDeNivel(){
		if (this.estaEnUltimoNivel())
			this.felicitaciones();
		else
			this.setNivelActual(this.getNivelActual()+1);
	}
	
	public void felicitaciones(){
		//TODO mostrar en pantalla q ganaste
	}
	
	public boolean estaEnUltimoNivel(){
		return (this.nivelActual == this.cantidadNiveles);
	}
	
	//falta test
	public void agregarNivel(Nivel unNivel){
		niveles.add(unNivel);
	}
	
	//falta test
	public void eliminarNivel(Nivel nivelSeleccionado) {
		niveles.remove(nivelSeleccionado);
		
	}

}
