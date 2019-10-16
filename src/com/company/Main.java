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

    public static void main(String[] args) {
        ArrayList lista = new ArrayList();
	  readFile("caso1.txt", lista);
        for(int i=0; i<lista.size();i++) {
            System.out.println(lista.get(i));

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
