package br.com.fintech.model.entity;

public class PessoaEntity {
        private String nome;
        private String documento;
        private boolean pessoaJuridica = false;
        private String email;
        private String telefone;

        public PessoaEntity(String nome, String cpf, String email, String telefone) {}

        public PessoaEntity(String nome, String documento, boolean pessoaJuridica, String email, String telefone) {
            this.nome = nome;
            this.documento = documento;
            this.pessoaJuridica = pessoaJuridica;
            this.email = email;
            this.telefone = telefone;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public boolean isPessoaJuridica() {
            return pessoaJuridica;
        }

        public void setPessoaJuridica(boolean pessoaJuridica) {
            this.pessoaJuridica = pessoaJuridica;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }


    }

