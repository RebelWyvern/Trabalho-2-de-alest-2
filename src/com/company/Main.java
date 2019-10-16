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

	    readFile("caso1.txt", lista);
	    quantidadetubos = (int) lista.remove(0);
	    lista.remove(0);
        barraca = new Barraca();
        criaGrafo();
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


}
