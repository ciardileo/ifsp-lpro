package calculo.calcular;

public class Logaritmo {
	private float resultado;
	
	public Logaritmo() {
		
	}
	
	public float Log(float num1) {
		resultado = (float) Math.log10(num1);
		return resultado;
	}
	public float getResultado() {
		return resultado;
	}
}
