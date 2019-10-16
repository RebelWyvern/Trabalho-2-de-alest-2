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
    public static ArrayList<Tubo> tubos=new ArrayList<>();

    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
	  readFile("caso1.txt", lista);
        /*for(int i=0; i<lista.size();i++) {
            System.out.println(lista.get(i));
        }*/
        resposta(lista);
        maior();
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

    public static void resposta(ArrayList lista)
    {
        Tubo tubo;
        int t = (int) lista.remove(0);
        lista.remove(0);
        int t2, idtubos;

        for(int j=0;j<t;j++)
        {
            tubo = new Tubo();
            tubo.nome = j;
            tubos.add(tubo);
        }

        for (int i=0; i<lista.size();i=i+4){
            t2 = (int) lista.get(i);
            idtubos = procuraTudo(t2);
            if(-1 != idtubos){
                tubos.get(idtubos).incqtd();
            }else{
                System.out.println("Nao achou");
                break;
            }
        }
    }

    public static int procuraTudo(int n)
    {
        for(int i=0;i<tubos.size();i++)
        {
            if(n==tubos.get(i).getNome())
            {
                return i;
            }
        }
        return -1;
    }

    public static void maior()
    {
        int nome = 0;
        int maior = 0;
        for(int i=0;i<tubos.size();i++){
            if(maior < tubos.get(i).getQtd()){
                maior = tubos.get(i).getQtd();
                nome = tubos.get(i).getNome();
            }
        }
        System.out.println("Maior: " + nome + " com " + maior);
    }
}
