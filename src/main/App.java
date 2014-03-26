package main;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.Exception;
//import java.lang.System;
//
//import java.net.*;
//import java.io.*;

import java.lang.Exception;

public class App {

    public static String BASE_PATH = "source/";

    public static String sourcePath;
    public static String sourceDir;
    public static String csvName;

    public static void main(String[] args) throws Exception{
        csvName = args[0];
        sourceDir = args[1];
        sourcePath = BASE_PATH + sourceDir + "/";

        FileWork f = new FileWork();

        ParseCsv parse = new ParseCsv(csvName, f);
    }


}