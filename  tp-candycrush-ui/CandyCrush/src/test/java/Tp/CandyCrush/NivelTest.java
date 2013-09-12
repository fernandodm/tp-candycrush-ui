package Tp.CandyCrush;

import junit.framework.Assert;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class NivelTest extends TestCase {
	private Dificultad dificultad;
	private Nivel nivel;
	
	public void setUp(){
		
		nivel = new Nivel();
		dificultad = mock(Dificultad.class);
		nivel.setDificultad(dificultad);
		
		when(dificultad.colorCaramelo()).thenReturn("Azul");
	}
	
	public void testCarameloAleatorio(){
		
		Caramelo caramelo = nivel.carameloAleatorio();		
		Assert.assertEquals(caramelo.getColor(), "Azul");
	}
}
