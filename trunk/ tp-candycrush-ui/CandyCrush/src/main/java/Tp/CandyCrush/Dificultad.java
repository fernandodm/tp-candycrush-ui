package Tp.CandyCrush;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Dificultad {
	public static final Dificultad DIFICIL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo", "Naranja", "Violeta"),"Facil");
	public static final Dificultad NORMAL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo", "Naranja"),"Normal");
	public static final Dificultad FACIL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo"),"Dificil");
	private List<String> colores = new ArrayList<String>();
	private String nombre;
	
	public static List<Dificultad> getDificultades() { 
		return Arrays.asList(DIFICIL, FACIL, NORMAL);
	}
	
	private Dificultad(List<String> colores, String nombre) {
		this.colores = colores;
		this.setNombre(nombre);
	}
	
	public Dificultad(){
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static Dificultad getDificil() {
		return DIFICIL;
	}

	public static Dificultad getNormal() {
		return NORMAL;
	}

	public static Dificultad getFacil() {
		return FACIL;
	}

	public List<String> getColores() {
		return colores;
	}

	public void setColores(List<String> colores) {
		this.colores = colores;
	}

	public String colorCaramelo() {
		
		int num = (int) (Math.random() * (getColores().size())); 
		
		return getColores().get(num);
	}
	
	public static void main(String[] args) {
	
	}	
}
