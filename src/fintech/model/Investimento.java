package fintech.model;

public class Investimento {
    private int idInvestimento;
    private String tipoInvestimento; // Ex: "Renda Fixa", "Renda Variável"
    private double montante;
    private double taxaJuros;
    
    // Construtor padrão
    public Investimento() {
    }
    
    // Construtor com parâmetros
    public Investimento(int idInvestimento, String tipoInvestimento, double montante, double taxaJuros) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.montante = montante;
        this.taxaJuros = taxaJuros;
    }
    
    // Método para simular o cálculo do retorno do investimento
    public void calcularRetorno() {
        System.out.println("Calculando retorno para investimento de " + tipoInvestimento + " com montante: " + montante);
    }
}
