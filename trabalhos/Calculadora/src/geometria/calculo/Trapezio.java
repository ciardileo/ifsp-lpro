package geometria.calculo;

public class Trapezio {
	private float baseMaior;
	private float baseMenor;
	private float altura;
	
	// construtor
	public Trapezio(float baseMaior, float baseMenor, float altura) {
		this.baseMaior = baseMaior;
		this.baseMenor = baseMenor;
		this.altura = altura;
	}
	
	// setters 
	public void setBaseMaior(float baseMaior) {
		this.baseMaior = baseMaior;
	}
	
	public void setBaseMenor(float baseMenor) {
		this.baseMenor = baseMenor;
	}
	
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	// getters
	public float getBaseMaior() {
		return baseMaior;
	}
	
	public float getBaseMenor() {
		return baseMenor;
	}
	
	public float getAltura() {
		return altura;
	}
	
	// retorna a area
	public float area() {
		return ((baseMaior + baseMenor) * altura) / 2;
	}
}
