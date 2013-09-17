package Tp.CandyCrush;

import java.util.ArrayList;

public class ExplosionesPorColor extends Objetivo {

	private String color;
	private int cantidad;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public ExplosionesPorColor(String color, int cantidad){
		this.setColor(color);
		this.setCantidad(cantidad);
		this.setSeCumplio(false);
	}
	
	public void complete(){
		if(this.getCantidad() == 0){
			this.setSeCumplio(true);
		}
	}
	
	public void actualizarObjetivo(Explosion exp){
		
		if(exp.getColor() == this.getColor()){
			this.setCantidad(this.getCantidad() - exp.getCantidad());
		}
		this.complete();
	}
	
	
	
}
