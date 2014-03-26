package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Exception;
import java.lang.System;

import java.lang.Thread;
import java.net.*;
import java.io.*;

class ParseCsv {

    private String csvFile; // path to file
    private BufferedReader br = null;
    private String line = "";
    private String cvsSplitBy = ",";

    private FileWork work;

    ParseCsv(String csvName, FileWork f) throws Exception {
        work = f;
        csvFile = csvName;
        run();
    }
    private void run() throws Exception {
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);


                System.out.println(" -----------------------");
                System.out.println("|");

                if(country.length > 0){
                    if(testData(country)){
                        boolean a =  work.run(country);
                    }

                }


                if(country.length > 3)System.out.println("Lose!: " +  country[3]);
                System.out.println("                       |");
                System.out.println("-----------------------;\n\n");
//                Thread.sleep(300);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\nDone\n");
    }
    private boolean testData(String[] arr){

        //TODO: проверить проходим ли каждую строку или
        System.out.println("Columns length: " + arr.length + "\n");

        if(arr.length > 5){
            /*System.out.println(arr[3]);
            System.out.println(arr[4]);
            System.out.println(arr[5]);
            System.out.println(arr[6]);
            System.out.println(" ");
            */
            return true;
        } else {
            return false;
        }
    }
}

