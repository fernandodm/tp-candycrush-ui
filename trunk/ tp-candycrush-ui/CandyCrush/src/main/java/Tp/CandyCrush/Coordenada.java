package Tp.CandyCrush;

import java.util.ArrayList;
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
	
	public static Coordenada coordenadaResultante(Coordenada c, List<Movimiento> mov){
		Coordenada aux= c;
		for(Movimiento each: mov){
			aux= each.coordenadaMovimiento(aux);
		}
		return aux;
	}
	
	

}
