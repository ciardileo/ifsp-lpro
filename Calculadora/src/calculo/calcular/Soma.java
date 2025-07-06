package calculo.calcular;

public class Soma {
	private float resultado;
	
	public Soma() {
		
	}
	
	public float Somar(float num1, float num2) {
		resultado = num1 + num2; 
		return resultado;
	}
	
	public float getResultado() {
		return resultado;
	}
}
