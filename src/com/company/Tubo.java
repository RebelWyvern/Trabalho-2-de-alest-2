package com.company;

import java.util.ArrayList;

public class Tubo {
    public int nome;
    public int quantBolinha;
    public ArrayList<Buraco> buracos = new ArrayList<Buraco>();

    public Tubo (int nome){this.nome = nome;}

    public int getNome() {
        return nome;
    }
    public void setNome(int nome) {
        this.nome = nome;
    }
    public ArrayList<Buraco> getBuracos() {
        return buracos;
    }

    public void adicionaBolinha(){
        this.quantBolinha++;
    }

    public int achaBuraco(int nome){
        for (int i = 0; i< buracos.size(); i++){
            if(nome == buracos.get(i).getNome()){ //se ele ja existe
                return i;
            }
        }
        return -1;//se nao achou esse buraco (nao esta criado ainda)
    }
}
