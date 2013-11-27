package Tp.CandyCrush;

import java.io.Serializable;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Objetivo implements Serializable{

	private boolean seCumplio;
	private String color;
	private boolean sePuedeAgregar;
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isSePuedeAgregar() {
		return sePuedeAgregar;
	}

	public void setSePuedeAgregar(boolean sePuedeAgregar) {
		this.sePuedeAgregar = sePuedeAgregar;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isSeCumplio() {
		return seCumplio;
	}

	public void setSeCumplio(boolean seCumplio) {
		this.seCumplio = seCumplio;
		this.setSePuedeAgregar(this.puedeAgregarObjetivo());
	}
	
	public abstract boolean puedeAgregarObjetivo();
	
	public String seCumplioDescripcion(){
		if(this.isSeCumplio()){
			return "OK!";
		} else {
			return "No cumplido";
		}
	}
	
	public abstract boolean esGrandesExplosiones();
	public abstract boolean esExplosionesPorColor();	
	
	public abstract void actualizarObjetivo(Explosion exp);

	public abstract String getDescripcion();
	
}
