package EstrututraWhile;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int totalAlunos = 10;
        Scanner input = new Scanner(System.in);

        while (totalAlunos > 0) {
            String nomeAluno = input.nextLine();
            int idadeAluno = input.nextInt();
            System.out.println("O nome do aluno é; " + nomeAluno + "e sua idade "
                    + "é:" + idadeAluno);
            totalAlunos = totalAlunos - 1;

        }
        {

        }
    }
}
