package com.cescristorey.recyclerview.ejemplorecyclerview;

/**
 * Created by Luis on 23/10/2017.
 */

public class Coche {

    private String modelo;
    private String matricula;
    private String duenio;


    public Coche(String modelo, String matricula, String duenio) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.duenio = duenio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDuenio(String duenio){ this.duenio = duenio;  }

    public String getDuenio() { return this.duenio;  }


}
