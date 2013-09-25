package Tp.CandyCrush;




public class ExplosionesPorColor extends Objetivo {

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
