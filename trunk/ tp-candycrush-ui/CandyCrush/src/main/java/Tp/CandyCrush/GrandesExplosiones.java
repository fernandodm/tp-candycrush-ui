package Tp.CandyCrush;

public class GrandesExplosiones extends Objetivo {

	private Integer cantidadGrandesExplosiones;
	
	public String getDescripcion(){
		return "Explotar " + getCantidadGrandesExplosiones() + " " + getColor();
	}
	
	public Integer getCantidadGrandesExplosiones() {
		return cantidadGrandesExplosiones;
	}

	public void setCantidadGrandesExplosiones(Integer cantidadGrandesExplosiones) {
		this.cantidadGrandesExplosiones = cantidadGrandesExplosiones;
		this.setSePuedeAgregar(this.puedeAgregarObjetivo());
	}
	
	public GrandesExplosiones(String color, Integer cant){
		this.setColor(color);
		this.setCantidadGrandesExplosiones(cant);
		this.setSeCumplio(false);
	}
	
	public GrandesExplosiones() {
		
	}

	public void complete(){
		if(this.getCantidadGrandesExplosiones() == 0){
			this.setSeCumplio(true);
		}
	}
	
	public void actualizarObjetivo(Explosion exp){
		
		if(exp.getColor() == this.getColor() && exp.getCantidad() > 3){
			this.setCantidadGrandesExplosiones(this.getCantidadGrandesExplosiones() - 1);
		}
		this.complete();
	}

	@Override
	public boolean puedeAgregarObjetivo() {
		return	this.getCantidadGrandesExplosiones() != null &&
				this.getColor() != null;
	}
	
	
}
