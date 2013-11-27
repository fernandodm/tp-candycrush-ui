package Tp.CandyCrush;

import java.io.Serializable;
import java.util.ArrayList;

public class Fila implements Serializable {

	ArrayList<Caramelo> caramelos = new ArrayList<Caramelo>();

	public ArrayList<Caramelo> getCaramelos() {
		return caramelos;
	}

	public void setCaramelos(ArrayList<Caramelo> caramelos) {
		this.caramelos = caramelos;
	}
	
	public Fila(){
		
	}
	
	public String contenido(){
		String largo = "";
		
		for(Caramelo each : this.getCaramelos()){
			largo = largo + each.getColor();
			largo = largo + this.agregarEspacios(each.getColor());
		}
		
		return largo;
	}
	
	public String agregarEspacios(String c){
		String espacios = "";
		
		if(c.length() < 8){
			for(int i = 0; i < (8 - c.length()); i++){
				espacios = espacios + "_";
			}
		}
		return espacios + "|";
	}
	
}
