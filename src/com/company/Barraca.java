package com.company;

import java.util.ArrayList;

public class Barraca { //é o conjuntoq ue guarda todos os tubos
    public ArrayList<Tubo> tubos = new ArrayList();
    public Barraca(){}

    public ArrayList<Tubo> getTubos() {
        return tubos;
    }

    public int achaTubo(int nome){
        for (int i = 0; i< tubos.size(); i++){
            if(nome == tubos.get(i).getNome()){ //se ele ja existe
                return i;
            }
        }
        return -1;//se nao achou esse tubo (nao esta criado ainda)
    }

    public void ordenaTubos(){
        Tubo a,b;
        for(int i = 0; i<tubos.size();i++){
            for(int p = 0; p<tubos.size();p++){
                if(tubos.get(i).getNome() < tubos.get(p).getNome()){
                    a = tubos.get(i);
                    b = tubos.get(p);
                    tubos.set(i,b);
                    tubos.set(p,a);
                }
            }
        }
    }

    public void printaTubos(){
        for (int i = 0; i<tubos.size();i++){
            System.out.println("Tubo: " + tubos.get(i).getNome());
        }
    }
}
