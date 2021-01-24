package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryOfChat {
    private static String FileWay="D:\\NewFileDataBass.txt";
    public static void creatFile(){
        File newFile = new File(FileWay);
        try {
            boolean created = newFile.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }



}
    public static String takeOfTheFile() {

       String myStr=" ";
        try(FileReader reader = new FileReader(FileWay))
        {
            // читаем посимвольно
            int c;

            while((c=reader.read())!=-1){


               myStr+= Character.toString((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
            String[] newMyStr=myStr.split("\n");
        if(newMyStr.length>99) {
            String lastMyStr =" ";

            for (int i = 99; i >= 1; i--) {

                lastMyStr+= (newMyStr[newMyStr.length - i]+"\n ");


                // return lastMyStr;


            }
            System.out.println(lastMyStr);
           return lastMyStr;
        }else {

            return myStr;
        }

    }
    public static void putInText(String textIn){
        try(FileWriter writer = new FileWriter(FileWay, true))
        {
            // запись всей строки

            writer.write(textIn);
            // запись по символам
            writer.append('\n');


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
