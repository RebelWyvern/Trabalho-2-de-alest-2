package com.company;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList lista = new ArrayList();
    public static int quantidadetubos;
    public static Barraca barraca;
    public static int i = -1;

    public static void main(String[] args) {

	    readFile("anivia.txt", lista);
	    quantidadetubos = (int) lista.remove(0);
	    lista.remove(0);
        barraca = new Barraca();
        criaGrafo();
        System.out.println("SAI DO CRIAGRAFO");
        //percorre o grafo e adiciona a quantidade de bolinhas para cada tubo
        barraca.ordenaTubos();
        for (Tubo t:barraca.getTubos()) {
            t.ordenaBuracos();
        }
        for(int i=0;i<barraca.getTubos().size();i++)
        {
            System.out.println("tubo a ser percorrido: "+barraca.getTubos().get(i).nome);
            percorreGrafo(barraca.tubos.get(i).buracos.get(0));
            System.out.println("///////////////////////////////////////////////////////");
        }

        maisBolinhas(barraca);
        //System.out.println("numero de bolinhas: "+barraca.tubos.get(0).quantBolinha);
        //System.out.println("primeiro buraco do tubo: "+barraca.tubos.get(0).buracos.get(4).tubodestino.getNome());

        //System.out.println(barraca.tubos.get(0).buracos.get(0).tubodestino.getNome());
        //System.out.println(barraca.tubos.get(0).buracos.get(0).nome);
        //percorreGrafo(barraca.tubos.get(0).buracos.get(0));
        //System.out.println("numero de bolinhas: "+barraca.tubos.get(0).quantBolinha);
        //System.out.println("tubo final: "+aux.nome);


    }

    public static void addTubosBarraca(int nome){
        Tubo t = new Tubo(nome);
        barraca.tubos.add(t);
    }

    public static int leTexto(){
        i++;
        return (int) lista.get(i);
    }

    public static void criaGrafo(){
        if(i < lista.size()-1) {
            Buraco buracoOrigem;
            Buraco buracoDestino;

            int tuboOrigem = leTexto();
            int posTuboOrigemnaBarraca = barraca.achaTubo((int) lista.get(i));
            if (-1 == posTuboOrigemnaBarraca) { //se nao tem o tubo
                //cria tubo
                addTubosBarraca(tuboOrigem);
                posTuboOrigemnaBarraca = barraca.achaTubo((int) lista.get(i));
            }
            Tubo ttuboOrigem = barraca.tubos.get(posTuboOrigemnaBarraca);

            int nomeBuracoOrigem = leTexto();
            int posBuradoOrigemnoTubo = ttuboOrigem.achaBuraco(nomeBuracoOrigem);
            if (-1 == posBuradoOrigemnoTubo) {//se nao tem o buraco
                //cria buraco
                buracoOrigem = new Buraco(ttuboOrigem,nomeBuracoOrigem);
                //adiciona o buraco no tubo
                ttuboOrigem.getBuracos().add(buracoOrigem);
                posBuradoOrigemnoTubo = ttuboOrigem.achaBuraco(nomeBuracoOrigem);
            }

            int tuboDestino = leTexto();
            int posTuboDestinonaBarraca = barraca.achaTubo((int) lista.get(i));
            if (-1 == posTuboDestinonaBarraca) { //se nao tem o tubo
                //cria tubo
                addTubosBarraca(tuboDestino);
                posTuboDestinonaBarraca = barraca.achaTubo((int) lista.get(i));
            }
            Tubo ttuboDestino = barraca.tubos.get(posTuboDestinonaBarraca);

            int nomeBuracoDestino = leTexto();
            int posBuradoDestinonoTubo = ttuboDestino.achaBuraco(nomeBuracoDestino);
            if (-1 == posBuradoDestinonoTubo) {//se nao tem o buraco
                //cria buraco
                buracoDestino = new Buraco(ttuboDestino,nomeBuracoDestino);
                //adiciona o buraco no tubo
                ttuboDestino.getBuracos().add(buracoDestino);
                posBuradoDestinonoTubo = ttuboDestino.achaBuraco(nomeBuracoDestino);
            }

            buracoOrigem = barraca.tubos.get(posTuboOrigemnaBarraca).buracos.get(posBuradoOrigemnoTubo);
            buracoDestino = barraca.tubos.get(posTuboDestinonaBarraca).buracos.get(posBuradoDestinonoTubo);


            buracoOrigem.buradoDestino = buracoDestino;
            buracoOrigem.tubodestino = ttuboDestino;
            buracoOrigem.tuboorigem = ttuboOrigem;

            criaGrafo();
        }
    }

    public static boolean readFile(String nomeArq, ArrayList lista) {
        Boolean result2=false;
        Path path1=Paths.get(nomeArq);
        try(Scanner sc=new Scanner(Files.newBufferedReader(path1,Charset.defaultCharset())))
        {
            String pal=null;
            //sc.useDelimiter(";");
            while(sc.hasNext())
            {
                pal=sc.next();
                lista.add(Integer.parseInt(pal));

                //System.out.println(pal);

            }
            result2=true;

        }

        catch(IOException e)
        {
            System.err.format("erro",e);
            result2=false;
        }

        return result2;
    }

    public static void percorreGrafo(Buraco b)
    {   int jaentrou=0;// variavel para ter ctz que a bolinha entre em apenas um buraco

        System.out.println("tubo q estou: "+b.tuboorigem.nome);
        //System.out.println("buraco q estou: "+b.nome);
        if(b.buradoDestino!=null)//se o buraco atual tiver um destino para ir
        { percorreGrafo(b.buradoDestino); }//chama recursivamente o metodo novamente passando o buraco destino do atual buraco
        else// se o buraco q estou não tiver destino, procura um buraco que está abaixo dele que tenha como ir para outro buraco
        {
            for(int i=0;i<b.tuboorigem.buracos.size();i++)
            {
                if(b.tuboorigem.buracos.get(i).nome==b.nome)
                {
                    for (int j=i+1;i<b.tuboorigem.buracos.size();j++)
                    {

                        if(b.tuboorigem.buracos.get(j).tubodestino!=null&&jaentrou==0)
                        {
                            percorreGrafo(b.tuboorigem.buracos.get(j).buradoDestino);
                            jaentrou++;
                        }
                        else if(j>=b.tuboorigem.buracos.size()-1)
                        {//se chegou no buraco final desse tubo e ele não tem destino, adiciona uma bolinha nesse tubo e termina o metodo
                            b.tuboorigem.adicionaBolinha();
                            return;
                        }
                    }

                }


            }
        }

    }

    public static void maisBolinhas(Barraca b)//metodo que descobre o tubo com mais bolinhas
    {
        Tubo vencedor=b.getTubos().get(0);//variavel para armazenar o tubo vencedor
        int cont=0;
        int cont2=1;
        while(cont<quantidadetubos&&cont2<quantidadetubos)//cont e cont2 servem para percorrer o vetor de tubos e comparar a quantidade de bolinhas de cada com cada
        {
            if(vencedor.quantBolinha<b.getTubos().get(cont2).quantBolinha)//se o tubo da posiçao de cont2 tiver mais bolinhas do que o tubo na variavel vencedor
            {
                vencedor=b.getTubos().get(cont2);//substitui o tubo que esta na variavel vencedor pelo que esta na posição do cont2
                cont++;
                cont2++;//avança as 2 variaveis
            }
            else// se o tubo da variavel vencedor ainda assim tiver o maior numero de bolinhas
            {
                cont2++;//avança somente cont2, assim so avançando cont quando o tubo da variavel vencedor tiver menos bolinhas do que esta na posição de cont2
            }
        }
        System.out.println("Tubo com mais bolinhas: "+vencedor.nome+"\nQuantidade de bolinhas do tubo vencedor: "+vencedor.quantBolinha);
    }

}
