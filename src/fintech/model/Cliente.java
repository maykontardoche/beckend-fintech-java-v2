package fintech.model;

public class Cliente extends Pessoa {
    private String endereco;
    
    // Construtor padrão
    public Cliente() {
        super();
    }
    
    // Construtor com parâmetros
    public Cliente(int id, String nome, String cpf, String email, String endereco) {
        super(id, nome, cpf, email);
        this.endereco = endereco;
    }
    
    // Método para exibir os dados do cliente
    public void mostrarDadosCliente() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf() + ", Email: " + getEmail() + ", Endereço: " + endereco);
    }
    
    // Getter e Setter para endereco
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
