package com.company;
import java.io.PrintWriter;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Stringdestroyer {
    public static void stringdestroyer(String csv_rpath,PrintWriter pw,StringBuilder sb,StringBuilder in) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(csv_rpath));
            String line = "";

            while((line = br.readLine()) != null){

                String[] value = line.split("(,|;)(?=(?:[^“]*“[^“]*“)*[^“]*$)");

                for(int i = 0; i < value.length; i++) {

                    if(value[i]==""){
                        continue;
                    }


                    if(value[i].indexOf("“") == 0){
                        value[i] = value[i].replaceFirst("“","");

                        if(value[i].contains("““") == true){
                            value[i] = value[i].substring(0,value[i].length()-1);
                            value[i] = value[i].replaceFirst("““","“");
                        }else if(value[i].indexOf("“") != value[i].length()-1){
                            value[i] = value[i].replaceFirst("“","");
                        }else{
                            value[i] = value[i].replace(value[i].substring(value[i].length()-1),"");
                        }


                    }else if(value[i].contains("““") == true){

                        value[i] = value[i].replaceFirst("““","“");

                    }else if(value[i].indexOf("“") != 0 && value[i].contains("“") == true){
                        String[] dopp = value[i].split(",");
                        for(int a=0;a<dopp.length;a++){
                            sb.append(dopp[a]+" ");
                            in.append(dopp[a].length()+"+");
                        }
                        continue;


                    }else{
                        value[i] =value[i];
                    }

                    sb.append(value[i]+" ");
                    in.append(value[i].length()+"+");

                }

                sb.append(in);
                sb.deleteCharAt(sb.lastIndexOf("+"));
                sb.append("\n");
                in.delete(0, in.length());
            }
            System.out.println(sb.toString());
            pw.write(sb.toString());
            pw.close();



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
