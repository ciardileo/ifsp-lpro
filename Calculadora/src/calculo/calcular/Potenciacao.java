package calculo.calcular;

public class Potenciacao {
	private float resultado;
	
	public Potenciacao() {
		
	}
	
	public float Potencia(float num1, float num2) {
		resultado = (float) Math.pow(num1, num2);
		return resultado;
	}
	public float getResultado() {
		return resultado;
	}
	
}
