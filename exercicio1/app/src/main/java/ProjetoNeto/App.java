package ProjetoNeto;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int ano, mes;
        System.out.println("Informe o ano desejado ");
        ano = input.nextInt();
        System.out.println("Informe o mês desejado ");
        mes = input.nextInt();

        switch (mes) {
            case 1:
                System.out.println(" O mês de JANEIRO tem 31 dias");
                break;
            case 2:
                if (ano % 400 == 0) {
                    System.out.println("O mês FEVEREIRO tem 29 dias");

                } else {
                    System.out.println("O mês de FEVEREIRO tem 28 dias");
                }
                break;
            case 4:
                System.out.println("O mês de MARÇO tem 31 dias ");
                break;
            case 5:
                System.out.println(" O mês de ABRIL tem 30 dias");
                break;
            case 6:
                System.out.println("O mês de MAIO tem 31 dias");
                break;
            case 7:
                System.out.println("O mês de JUNHO tem 30 dias");
                break;
            case 8:
                System.out.println("O mês de JULHO tem 31 dias");
                break;
            case 9:
                System.out.println("O mês de AGOSTO tem 31 dias");
                break;
            case 10:
                System.out.println("O mês de SETEMBRO tem 30 dias");
                break;
            case 11:
                System.out.println("O mês de OUTUBRO tem 31 dias");
                break;
            case 12:
                System.out.println("O mês de NOVEMBRO tem 30 dias");
                break;
            case 3:
                System.out.println("O mÊs de DEZEMBRO tem 31 dias");
                break;
        }
        if (ano % 400 == 0) {
            System.out.println("O ano que você escolheu é BISSEXTO");
        } else {
            System.out.println("O ano informado é " + ano + " e o mês foi o " + mes);
            System.out.println("O ano informado não é bissexto");

        }
    }
}
