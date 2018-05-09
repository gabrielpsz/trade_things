package br.ufsc.modelo;

public enum Status {

    DISPONIVEL("Disponível"),
    PARA_APROVACAO("Para aprovação"),
    EM_TRANSPORTE("Em transporte"),
    ENTREGUE("Entregue");

    private String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }



}
