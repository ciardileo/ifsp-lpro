import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        
        Double[] alturas = new Double[5];

        System.out.println("Escreva 5 alturas:");
        
        for (int i = 0; i < alturas.length; i++) {
			alturas[i] = leia.nextDouble();
		}

        Double maior;
        maior = 0.0;

		Double menor;
		menor = 0.0;

		menor = alturas[0];
        for (int i = 0; i < alturas.length; i ++){
			if (menor > alturas[i]) {
				menor = alturas[i];
			}
            if (maior < alturas[i]){
                maior = alturas[i];
            }

        }

        System.out.println("A maior altura é: " + maior);
		System.out.println("A menor altura é: " + menor);

    }
}
