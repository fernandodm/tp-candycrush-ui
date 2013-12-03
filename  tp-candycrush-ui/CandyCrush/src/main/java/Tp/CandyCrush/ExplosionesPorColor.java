package Tp.CandyCrush;

import java.io.Serializable;






public class ExplosionesPorColor extends Objetivo implements Serializable{


	private Integer cantidad;
	
	@Override
	public boolean puedeAgregarObjetivo (){
		
		return  this.getColor() != null &&
				this.getCantidad() != null && 
				this.getCantidad() > 0;
		
	}
	
			
	public String getDescripcion(){
		return "Realizar " + getCantidad() + " esplosion/es de caramelos " + getColor();
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
		this.setSePuedeAgregar(this.puedeAgregarObjetivo());
	}
	

	public ExplosionesPorColor(String color, int cantidad){
		this.setColor(color);
		this.setCantidad(cantidad);
		this.setSeCumplio(false);
	}
	
	public ExplosionesPorColor() {
		
	}
	public void complete(){
		if(this.getCantidad() < 1){
			this.setSeCumplio(true);
		}
	}
	
	public void actualizarObjetivo(Explosion exp){
		
		if(exp.getColor() == this.getColor()){
			if(this.getCantidad()>0){
				this.setCantidad(this.getCantidad() - exp.getCantidad());
			}
			else{
				this.setCantidad(0);
			}
		}
		this.complete();
	}


	@Override
	public boolean esGrandesExplosiones() {
		return false;
	}


	@Override
	public boolean esExplosionesPorColor() {
		return true;
	}
	
	
	
}
