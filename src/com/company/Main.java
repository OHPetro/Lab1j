package com.company;
import java.io.PrintWriter;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;



public class Main {

    static String csv_rpath = "src/com/company/rLab1.csv";
    static String csv_wpath = "src/com/company/wLab1.csv";

    public static void main(String[] args) {

        System.out.println("Write a delimiter : ");
        Scanner s = new Scanner(System.in);
        String delimiter = s.nextLine();
        String line = "";


        try {
            PrintWriter pw = new PrintWriter(csv_wpath);
            StringBuilder sb = new StringBuilder();
            StringBuilder in = new StringBuilder();

            Stringdestroyer.stringdestroyer(csv_rpath,pw,sb,in);


        }catch(FileNotFoundException e){
            System.out.println("pezda");
        }


    }
}
