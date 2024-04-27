package domain;

import domain.Sexo;

public abstract class Persona {
    private String nombre;
    private Integer edad;
    private String direccion;
    private Sexo sexo;

    public Persona(String nombre, String direccion, Sexo sexo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sexo = sexo;
    }

    public void solicitarAcompanamiento() {

    }
}