package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dificultad {
	public static final Dificultad DIFICIL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo", "Naranja", "Violeta"));
	public static final Dificultad NORMAL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo", "Naranja"));
	public static final Dificultad FACIL = new Dificultad(Arrays.asList("Amarillo", "Celeste", "Verde", "Rojo"));
	private List<String> colores = new ArrayList<String>();
	
	public static List<Dificultad> getDificultades() { 
		return Arrays.asList(DIFICIL, FACIL, NORMAL);
	}
	
	public Dificultad(){
		
	}
	
	private Dificultad(List<String> colores) {
		this.colores = colores;
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
		System.out.println(getDificultades().size());
	}
	
}
