package geometria.calculo;

public class Triangulo {
	private float base;
	private float altura;
	
	// construtor
	public Triangulo(float base, float altura) {
		this.base = base;
		this.altura = altura;
	}
	
	// setter da base
	public void setBase(float base) {
		this.base = base;
	}
	
	// getter da base
	public float getBase() {
		return base;
	}
	
	// setter da altura
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	// getter da altura
	public float getAltura() {
		return altura;
	}
	
	// retorna a área
	public float area() {
		return (base * altura) / 2;
	}
}
