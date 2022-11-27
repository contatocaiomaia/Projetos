package Exercicio1PPO;

public class Pessoa {

    private String nome;
    private int dataNascimento;
    private double altura;

    public Pessoa(String nome, int dataNascimento, double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void ImprimirDados() {
        System.out.println("IMPRIMINDO DADOS DA PESSOA");
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("Altura: " + this.altura);
        System.out.println("------------------------------------------");
    }

    public void ImprimirIdade(int anoAtual, int anoNascimento) {
        int idade = anoAtual - anoNascimento;
        System.out.println("Sua idade é: " + idade);
        System.out.println("------------------------------------------");
    }

}
