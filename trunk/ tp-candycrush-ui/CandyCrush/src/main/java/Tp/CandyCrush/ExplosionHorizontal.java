package Tp.CandyCrush;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExplosionHorizontal extends TipoDeExplosion implements Serializable{

	@Override
	public void propagarExplosion(Tablero t, Coordenada c) {
		String color = t.colorCarameloEn(c);
		Explosion exp = new Explosion(1, color); 
		List<Coordenada> car= new ArrayList<Coordenada>();
		car.add(c);
		this.propagarHacia(t, c, exp, car, new Izquierda());
		this.propagarHacia(t, c, exp, car, new Derecha());
        this.notificarExplosion(exp, car, t);
        this.explotarCaramelos(t, car);

	}

}
