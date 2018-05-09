package br.ufsc.modelo;

public enum Tipo {

    MATERIAL_ESPORTIVO("Material esportivo"),
    MODA("Moda"),
    CONSUMIVEL("Consumível"),
    OBJETO("Objeto"),
    OUTROS("Outros");

    Tipo(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return this.label;
    }

}
