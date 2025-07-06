package calculo.calcular;

public class Exponenciacao {
	private float resultado;
	
	public Exponenciacao() {
		
	}
	
	public float Exponencial(float num1) {
		resultado = (float) Math.exp(num1);
		return resultado;
	}
	
	public float getResultado() {
		return resultado;
	}
}
