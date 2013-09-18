package Tp.CandyCrush;

import java.util.ArrayList;
import java.util.List;

public class ExplosionEnCruz extends TipoDeExplosion {

	@Override
	public void propagarExplosion(Tablero t, Coordenada c) {
		String color = Caramelo.colorCaramelo(t, c);
		Explosion exp = new Explosion(1, color); 
		List<Coordenada> car= new ArrayList<Coordenada>();
		car.add(c);
		this.propagarHacia(t, c, exp, car, new Arriba());
		this.propagarHacia(t, c, exp, car, new Abajo());
		this.propagarHacia(t, c, exp, car, new Izquierda());
		this.propagarHacia(t, c, exp, car, new Derecha());
        this.notificarExplosion(exp);
        this.explotarCaramelos(t, car);

	}

}
