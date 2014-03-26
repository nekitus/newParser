package main;

import javax.xml.transform.Templates;
import java.io.File;
import java.io.PrintWriter;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.System;
import java.lang.Thread;
import java.net.URL;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;


class FileWork {

    private String basePath;

    public FileWork() throws Exception {

    }

    public boolean run(String[] country) throws Exception {
        String filename = getFileName(country[3]).split("\\.")[0];
        String enSubtitle = country[4];
        String esSubtitle = country[5];


        if(!enSubtitle.contains(".htm")){
            writeLog("no extention \"htm\": ," + enSubtitle + ";");
            enSubtitle += ".htm";
        }

        if(!esSubtitle.contains(".htm")){
            writeLog("no extention \"htm\": ," + esSubtitle + ";");
            esSubtitle += ".htm";
        }

        String enSubtitPath = App.sourcePath + enSubtitle;
        String esSubtitPath = App.sourcePath + esSubtitle;

        String file_part = filename.split("\\.")[0];

        if(filename.length() <= 0){
            return  true;
        }

        String swfFile = file_part.substring(1, file_part.length()) + ".swf";
        String swfFile2 = enSubtitle.split("\\.")[0] + ".swf";
        swfFile2 = swfFile2.replace("_en", "");
        swfFile2 = swfFile2.replace("_es", "");


        String swfPath = App.sourcePath + swfFile;
        String swfPath2 = App.sourcePath + swfFile2;

        String xmlPath = App.sourcePath + filename + ".xml";


        String source;
/*
        boolean flag = true;

        switch (flag) {
            case testFile(swfPath):
                burnFile(FileTemplate.gethtml(filename, App.sourceDir), "src/" + filename + ".html");

                source = FileTemplate.getxml(enSubtitle, esSubtitle, swfFile);

                burnFile(source, xmlPath);

                break;
            case testFile(swfPath2):
                // burn html
                burnFile(FileTemplate.gethtml(filename, App.sourceDir), "src/" + filename + ".html");

                source = FileTemplate.getxml(enSubtitle, esSubtitle, swfFile2);

                burnFile(source, xmlPath);
                break;
            default:
                writeLog("not found files: " + swfFile + ", " + swfFile2 + ";");
//                burnFile("", "src/log.csv");
*/

        section:
        {
            if (testFile(swfPath)) {
                // burn html
                burnFile(FileTemplate.gethtml(filename, App.sourceDir), "src/" + filename + ".html");

                source = FileTemplate.getxml(enSubtitle, esSubtitle, swfFile);

                burnFile(source, xmlPath);

                break section;
            } else if (testFile(swfPath2)) {
                // burn html
                burnFile(FileTemplate.gethtml(filename, App.sourceDir), "src/" + filename + ".html");

                source = FileTemplate.getxml(enSubtitle, esSubtitle, swfFile2);

                burnFile(source, xmlPath);
                break section;
            }
            writeLog("not found files: ," + swfFile + ", " + swfFile2 + ";");

        }
        return true;
    }

    public void writeLog(String sourceString) throws Exception {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("log.csv", true), "UTF-8"));
        pw.println(sourceString);
        pw.close();
    }

    public boolean testFile(String path) {
//        "src/" + path + "/" +  testFile + ".swf"
        File f = new File(path);
        if (f.exists() && !f.isDirectory()) {
            System.out.println("File: " + path + " FIND SUCCESS!");
            return true;
        } else {
            System.out.println("File: " + path + " NOT FOUND!");
            return false;
        }
    }

    public boolean burnFile(String sourceString, String path) throws Exception {
//        "src/" + filename + ".html"
        PrintWriter writer = new PrintWriter(path, "UTF-8");

        writer.println(sourceString);
        writer.close();
        return true;
    }

    /*


     PrintWriter writer = new PrintWriter("src/" + filename + ".html", "UTF-8");

        String htmlString = gethtml(filename, path);

        writer.println(htmlString);
        writer.close();

    */


    private String getFileName(String url) throws Exception {
        if (url.length() < 15) {
            return url + ".html";
        }
        URL aURL = new URL(url);
        String arr[] = aURL.getFile().split("/");

        return arr[arr.length - 1];
    }

    {

    }
}