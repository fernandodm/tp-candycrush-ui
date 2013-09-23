package Tp.CandyCrush;

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
	
	public Coordenada coordenadaResultante(List<Movimiento> mov){
		Coordenada aux= new Coordenada(this.getFila(), this.getColumna());
		for(Movimiento each: mov){
			aux= each.coordenadaMovimiento(aux);
		}
		return aux;
	}
	
	

}
