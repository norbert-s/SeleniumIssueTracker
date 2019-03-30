package testdatamanipulation;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class getData {
    FileWriter file;
    Random number,character;
    char a,c;
    String b="";
    BufferedWriter output;
    public String createData2(int num, Properties prop) throws IOException {
        number = new Random();
        int n = number.nextInt((1000-1)+1);
        character = new Random();
        String source = prop.getProperty("sourcefile");
        File existence = new File(source+num+".txt");
        if(existence.exists()){
//            SubWord a = new SubWord();
//            a.getString(num);
            FileInputStream filereader = new FileInputStream(source+num+".txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(filereader));
            String sor="";
            System.out.println("itt");

            while((sor=bufferedReader.readLine())!=null){
                b+=sor;
                System.out.println(sor);
            }
            System.out.println(b);
            filereader.close();
            bufferedReader.close();
        }
        else{

            file = new FileWriter(source+num+".txt");

            for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);

            output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();

        }


        return b;
    }
    public String createDataDeprecated(int num, Properties prop) throws IOException {
        number = new Random();
        int n = number.nextInt((1000-1)+1);
        character = new Random();
        String source = prop.getProperty("sourcefile");
        File exists = new File(source+num+".txt");
            file = new FileWriter(source+num+".txt");
            for(int i=0;i<num;i++){

                if(i%5==0){
                    c=(char)32;
                }
                else{
                    c = (char)(character.nextInt(26) + 'a');
                }

                b+= c;
            }
            System.out.println("b"+b);
            output = new BufferedWriter(file);
            output.write(b);
//        output.flush();
            output.close();
        return b;
    }

    public String createData(int num, Properties prop) throws IOException {
        String library = prop.getProperty("sourcefiles");
        FileReader file = new FileReader(library+num+".txt");
        BufferedReader reader = new BufferedReader(file);
        StringBuilder string = new StringBuilder();
        String line = "";
        String lineConcat="";
        while((line = reader.readLine())!=null){
            lineConcat += line;
        }

        return lineConcat;
    }
    public String returnRandomLineNumberOfIds(Properties prop) throws IOException {
        FileReader file = new FileReader(prop.getProperty("ids"));
        BufferedReader reader = new BufferedReader(file);
        Random random = new Random();
        int lineNumber = random.nextInt((7-1+1)+1);
//        lineNumber = 2;
        System.out.println("linenumber"+lineNumber);
        String line="";
        for(int i=1;i<=lineNumber;i++){
            line = reader.readLine();
        }

        reader.close();

        return line;
    }

//    public String getString(int a, Properties prop) throws IOException {
//        FileInputStream is = new FileInputStream((prop.getProperty("sourcefiles"))+a+".txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String str;
//        String szo="";
//        while ((str = br.readLine()) != null)   {
//            szo += str;
//        }
//        return szo;
//    }

}
