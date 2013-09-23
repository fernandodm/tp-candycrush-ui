package Tp.CandyCrush;

public class GeneradorNroNivel {
	
	private static int nro = 0;
	
	public static int generar(){
		nro = nro + 1;
		return nro;
	}

	public static int getNro() {
		return nro;
	}

	public static void setNro(int nro) {
		GeneradorNroNivel.nro = nro;
	}

	public static void restarNroNivel() {
		nro = nro - 1;
		
	}

}
