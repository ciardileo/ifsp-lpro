package geometria.calculo;

public class Retangulo {
	private float base;
	private float altura;
	
	// construtor
	public Retangulo(float base, float altura) {
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
		return base * altura;
	}
	
	// retorna o perimetro
	public float perimetro() {
		return (base * 2) + (altura * 2);
	}
}
