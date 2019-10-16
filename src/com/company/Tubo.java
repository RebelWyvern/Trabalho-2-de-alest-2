package com.company;

public class Tubo {
    public int nome;
    public int qtd=0;

    public Tubo()
    {}
    public int getNome() { return nome; }

    public void setNome(int nome) { this.nome = nome; }

    public int getQtd() { return qtd; }

    public void setQtd(int qtd) { this.qtd = qtd; }

    public void incqtd(){this.qtd=qtd+1;}
}
