//35. Faça um algoritmo que calcule o valor da conta de luz de uma pessoa. Sabe-se que o cálculo da conta de
//luz segue a tabela abaixo:
//Tipo de Cliente Valor do KW/h
//a. (Residência) 0,60;
//b. (Comércio) 0,48;
package LojaDeCarro;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char repetir = 'S';
        double kwh, resultado;
        int opcao;
        while (repetir == 'S' && repetir == 's') {
            System.out.println("Informe o consumo em Kw/H");
            kwh = input.nextDouble();
            System.out.println("Pressione 1 - para Residência");
            System.out.println("Pressione 2 - para Comércio");
            System.out.println("Pressione 3 - para Indústria");
            opcao = input.nextInt();
            if (opcao == 1) {
                resultado = kwh * 0.48;
                System.out.println("O seu consumo foi de: " + resultado);
            }
            if (opcao == 2) {
                resultado = kwh * 0.60;
                System.out.println("O seu consumo foi de: " + resultado);

            }
            if (opcao == 3) {
                resultado = kwh * 1.29;
                System.out.println("O seu consumo foi de: " + resultado);
            }
        }
        System.out.println("Deseja repetir a co2nsulta? S/N");
        repetir = input.next().charAt(0);
    }
}
