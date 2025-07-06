package geometria.calculo;

public class Quadrado {
	private float lado;
	
	// construtor
	public Quadrado(float lado) {
		this.lado = lado;
	}
	
	// getter do lado
	public float getLado() {
		return lado;
	}
	
	// setter do lado
	public void setLado(float lado) {
		this.lado = lado;
	}
	
	// retorna a área
	public float area(){
		return lado * lado;
	}
	
	// retorna o perimetro
	public float perimetro() {
		return lado * 4;
	}
}
