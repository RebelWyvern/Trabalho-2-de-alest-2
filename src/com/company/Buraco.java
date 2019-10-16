package com.company;

public class Buraco {
    public int nome;
    public Tubo tuboorigem;
    public Tubo tubodestino;
    public Buraco buradoDestino;

    public Buraco(Tubo tuboorigem, int nome){
        this.nome = nome;
        this.tuboorigem = tuboorigem;
    }

    public int getNome() {
        return nome;
    }
    public Tubo getTuboorigem() {
        return tuboorigem;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }
    public void setTuboorigem(Tubo tuboorigem) {
        this.tuboorigem = tuboorigem;
    }
}
