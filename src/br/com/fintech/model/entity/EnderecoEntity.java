package br.com.fintech.model.entity;



public class EnderecoEntity {
        private String endereco;
        private String bairro;
        private String cidade;
        private String estado;
        private String cep;

        public EnderecoEntity() {}

        public EnderecoEntity(String endereco, String bairro, String cidade, String estado, String cep) {
                this.endereco = endereco;
                this.bairro = bairro;
                this.cidade = cidade;
                this.estado = estado;
                this.cep = cep;
        }

        public String getEndereco() {
                return endereco;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }

        public String getBairro() {
                return bairro;
        }

        public void setBairro(String bairro) {
                this.bairro = bairro;
        }

        public String getCidade() {
                return cidade;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public String getCep() {
                return cep;
        }

        public void setCep(String cep) {
                this.cep = cep;
        }

        @Override
        public String toString() {
                return String.format("%s | Bairros: %s | Cidade: %s | Estados: %s | C.E.P: %s",
                        endereco,
                        bairro,
                        cidade,
                        estado,
                        cep
                );
        }
}