package geometria.calculo;

public class Circulo {
	private float raio;
	
	// construtor
	public Circulo(float d) {
		this.raio = d;
	}
	
	// getters
	public float getRaio() {
		return raio;
	}
	
	// setters
	public void setRaio(float raio) {
		this.raio = raio;
	}
	
	// area
	public float area() {
		return (float) (Math.PI * (Math.pow(raio, 2)));
	}
	
	// circunferencia
	public float circunferencia() {
		return (float) (2 * raio * Math.PI);
	}
}
