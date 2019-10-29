package com.company;

import java.util.ArrayList;

public class Barraca { //é o conjuntoq ue guarda todos os tubos
    //public ArrayList<Tubo> tubos = new ArrayList();
    public Tubo[] tubos;
    public int contTubos;
    public Barraca(){
        tubos = new Tubo[1000000];
        contTubos = 0;
    }

    public void addemTubos(Tubo t){
        this.tubos[contTubos] = t;
        contTubos++;
    }

    public Tubo[] getTubos() {
        return tubos;
    }

    public int achaTubo(int nome){
        for (int i = 0; i< contTubos; i++){
            if(nome == tubos[i].getNome()){ //se ele ja existe
                return i;
            }
        }
        return -1;//se nao achou esse tubo (nao esta criado ainda)
    }

    public void ordenaTubos(){
        Tubo a,b;
        for(int i = 0; i<contTubos;i++){
            for(int p = 0; p<contTubos;p++){
                if(tubos[i].getNome() < tubos[p].getNome()){
                    a = tubos[i];
                    b = tubos[p];
                    tubos[i]=b;
                    tubos[p]=a;
                }
            }
        }
    }

    public void printaTubos(){
        for (int i = 0; i<tubos.length-1;i++){
            System.out.println("Tubo: " + tubos[i].getNome());
        }
    }
}
