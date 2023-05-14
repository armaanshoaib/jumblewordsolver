package jumble;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class FileWriterOnCond {
    public static void main(String[] args) {

        try {// fobj(filepointer) requires a try and catch block!
            File fobj = new File("sample.txt");//1)creates a file pointer to file
            Scanner fileReader = new Scanner(fobj);//3)creates a scanner object for the file pointer
            File fobj1 = new File("sample1.txt");
            while (fileReader.hasNextLine()) {// 4) checks whether file has next line
                String fileData = fileReader.nextLine();//5) creates a string and stores the file data into it
                fileData = fileData.toLowerCase(Locale.ROOT);//5.1)converts upper to lower
                try {
                    FileWriter fr = new FileWriter("sample1.txt",true);//6) creates a fp that writes in output file
                    if(fileData.startsWith("j")&&fileData.length()==3) {//condition that must be satisfied
                        fr.write(fileData);//writes the content(fileData) into output file
                        fr.write("\n");//for creating a new line otherwise entire content in ONE LINE only!
                    }
                    fr.close();
                } catch (IOException e) {//catch block if any exception while writing to sample1 file
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println(fileData);//)prints the string fD onto screen
            }
        }catch (FileNotFoundException e) {// exception handling while reading from sample file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

