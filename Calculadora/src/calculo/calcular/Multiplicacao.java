package calculo.calcular;

public class Multiplicacao {
	private float resultado;
	
	public Multiplicacao() {
		
	}
	
	public float Multiplicar(float num1, float num2) {
		resultado = num1 * num2;
		return resultado;
	}
	
	public float getResultado() {
		return resultado;
	}
}
