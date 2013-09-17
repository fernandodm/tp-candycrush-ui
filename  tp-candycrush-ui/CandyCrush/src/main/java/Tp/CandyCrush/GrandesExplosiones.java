package Tp.CandyCrush;

public class GrandesExplosiones extends Objetivo {

	private String color;
	private int cantidadGrandesExplosiones;
	
	public int getCantidadGrandesExplosiones() {
		return cantidadGrandesExplosiones;
	}

	public void setCantidadGrandesExplosiones(int cantidadGrandesExplosiones) {
		this.cantidadGrandesExplosiones = cantidadGrandesExplosiones;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public GrandesExplosiones(String color, int cant){
		this.setColor(color);
		this.setCantidadGrandesExplosiones(cant);
		this.setSeCumplio(false);
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
