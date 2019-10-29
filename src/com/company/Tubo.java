package com.company;

import java.util.ArrayList;

public class Tubo {
    public int nome;
    public int quantBolinha;
    public Buraco[] buracos;
    public Buraco ultimoBuraco;
    public int contburacosvetor;

    public Tubo (int nome){this.nome = nome;this.contburacosvetor = 0; buracos = new Buraco[10000];}

    public int getNome() {
        return nome;
    }
    public void setNome(int nome) {
        this.nome = nome;
    }
    public Buraco[] getBuracos() {
        return buracos;
    }

    public void adicionaBolinha(){
        this.quantBolinha++;
    }

    public int achaBuraco(int nome){
        for (int i = 0; i< contburacosvetor; i++){
            if(nome == buracos[i].getNome()){ //se ele ja existe
                return i;
            }
        }
        return -1;//se nao achou esse buraco (nao esta criado ainda)
    }

    public void ordenaBuracos(){
        Buraco a,b;
        for(int i = 0; i<contburacosvetor;i++){
            for(int p = 0; p<contburacosvetor;p++){
                if(buracos[i].getNome() < buracos[p].getNome()){
                    a = buracos[i];
                    b = buracos[p];
                    buracos[i] = b;
                    buracos[p] = a;
                }
            }
        }
        this.ultimoBuraco = buracos[contburacosvetor-1];
        //System.out.println("ANIVIA: " + ultimoBuraco.nome);
    }

    /*public void arrumaBuracos(Barraca b)
    {
        for (Tubo t:b.getTubos()) {
            for (Buraco ba:t.getBuracos()) {
                if(ba.tubodestino==null)
                {ba.tubodestino=new Tubo(-1);}
            }

        }
    }*/

    public void addBuraconoTubo(Buraco b){
        this.buracos[contburacosvetor] = b;
        this.contburacosvetor++;
    }

    public void printaBuraco(){
        for (int i = 0; i<contburacosvetor;i++){
            System.out.println("Buraco: " + buracos[i].getNome());
        }
    }
}
