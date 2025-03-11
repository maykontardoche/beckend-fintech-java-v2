package br.com.fintech.model.entity;
import java.util.UUID;

public class ClienteEntity extends PessoaEntity {
    private final UUID id = UUID.randomUUID();
    private EnderecoEntity endereco;

    public ClienteEntity(String nome, String documento, String email, String telefone, EnderecoEntity endereco) {
        super(nome, documento, false, email, telefone);
        this.endereco = endereco;
    }


    public UUID getId() {
        return id;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
    @Override
    public String toString() {
        return String.format(
                "Id: %s | Nome: %s | %s: %s | Email: %s | Telefone: %s | Endereço: %s",
                this.id,
                getNome(),
                isPessoaJuridica() ? "CNPJ" : "CPF",
                getDocumento(),
                getEmail(),
                getTelefone(),
                getEndereco().toString()
        );
    }


}

