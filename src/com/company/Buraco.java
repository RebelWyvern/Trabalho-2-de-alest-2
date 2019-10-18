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

    public Buraco pegaoProximoBuraco(){
        int aux = this.tuboorigem.achaBuraco(this.nome + 1);
        if(aux == -1){ //nao acho o proximo buraco
            return this;
        }
        return this.tuboorigem.buracos.get(aux);
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
