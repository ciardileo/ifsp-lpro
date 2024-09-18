package calculo.calcular;

public class Subtracao {
	private float resultado;
	
	public Subtracao(){
		
	}
	
	public float Subtrair (float num1, float num2) {
		resultado = num1 - num2;
		return resultado;
	}
	public float getResultado() {
		return resultado;
	}
}
