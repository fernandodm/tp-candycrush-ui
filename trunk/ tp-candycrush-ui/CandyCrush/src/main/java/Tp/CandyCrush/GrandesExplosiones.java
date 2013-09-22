package Tp.CandyCrush;

public class GrandesExplosiones extends Objetivo {

	private int cantidadGrandesExplosiones;
	
	public String getDescripcion(){
		return "Explotar " + getCantidadGrandesExplosiones() + getColor();
	}
	
	public int getCantidadGrandesExplosiones() {
		return cantidadGrandesExplosiones;
	}

	public void setCantidadGrandesExplosiones(int cantidadGrandesExplosiones) {
		this.cantidadGrandesExplosiones = cantidadGrandesExplosiones;
	}
	
	public GrandesExplosiones(String color, int cant){
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
	
	
}
