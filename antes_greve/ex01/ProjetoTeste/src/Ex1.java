import java.util.Scanner;

public class Ex1 {

    public Ex1(){

    }

    public static void main(String[] args){
        System.out.println("Programa de notas");

        Scanner leia = new Scanner(System.in);

        Double nota1;
        Double nota2;
        Double media;

        nota1 = leia.nextDouble();
        nota2 = leia.nextDouble();

        media = (nota1 + nota2) / 2;

        System.out.println("A média é: " + media);

        if (media >= 6) {
            System.out.println("Aprovado");
        } else if (4 <= media & media < 6){ 
            System.out.println("Em recuperação");
        } else{
            System.out.println("Reprovado");
        }
    }
}
