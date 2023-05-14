package jumble;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class FileWriterOnCond {
    public static void main(String[] args) {

        try {
            File fobj = new File("sample.txt");//1)creates a file pointer to file
            Scanner fileReader = new Scanner(fobj);//3)creates a scanner object for the file pointer
            File fobj1 = new File("sample1.txt");
            while (fileReader.hasNextLine()) {// 4) checks whether file has next line
                String fileData = fileReader.nextLine();//5) creates a string and stores the file data into it
                fileData = fileData.toLowerCase(Locale.ROOT);
                try {
                    FileWriter fr = new FileWriter("sample1.txt",true);
                    if(fileData.startsWith("j")&&fileData.length()==3) {
                        fr.write(fileData);
                        fr.write("\n");
                    }
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println(fileData);//6)prints the string fD onto screen
            }
        }catch (FileNotFoundException e) {// exception handling while reading from file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

