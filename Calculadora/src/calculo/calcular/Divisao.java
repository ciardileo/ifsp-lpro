package calculo.calcular;

public class Divisao {
	private float resultado;
	
	public Divisao() {
		
	}
	
	public float Dividir(float num1, float num2) {
		resultado = num1/num2;
		return resultado;
	}
	public float getResultado() {
		return resultado;	
	}
}
