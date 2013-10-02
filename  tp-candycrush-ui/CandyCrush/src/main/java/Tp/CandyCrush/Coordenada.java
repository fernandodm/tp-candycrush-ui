package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coordenada {
	
	private int fila ;
	private int columna;
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Coordenada(int fila, int columna){
		this.setFila(fila);
		this.setColumna(columna);
	}
	
	/**
	 * @param mov
	 * @return devuelve la coordenada que resulta de moverse hacia mov
	 */
	public Coordenada coordenadaResultante(List<Movimiento> mov){
		Coordenada aux= new Coordenada(this.getFila(), this.getColumna());
		for(Movimiento each: mov){
			aux= each.coordenadaMovimiento(aux);
		}
		return aux;
	}
	
	/**
	 * @param c
	 * @return devuelve true si this esta por debajo de c en el tablero
	 */
	public boolean tienePrioridad(Coordenada c){
		return this.getFila() > c.getFila() || (this.getFila() == c.getFila() && this.getColumna() < c.getColumna());
	}

	/**
	 * @param cs
	 * @return devuelve una coleccion de coordenadas que representa
	 * el orden por el cual hay q bajar las fichas
	 */
	public static List <Coordenada> ordenarParaRellenar(List<Coordenada> cs){
		    int pass, j; Coordenada tmp;
		    for( pass = 1; pass < cs.size(); pass++ )
		    {
		        tmp = cs.get(pass);
		        for( j = pass; j > 0 && tmp.tienePrioridad(cs.get(j-1)); j-- )
		            cs.set(j, cs.get(j-1));
		        cs.set(j, tmp);
		    }	
		return cs;
	}
 	
}
