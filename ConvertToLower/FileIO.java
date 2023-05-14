package jumble;
// THIS CODE CONVERTS THE CONTENT IN "words.txt" FILE TO lower case AND WRITES THEM INTO "wordssmall.txt"
//MAKE SURE THAT THESE FILES ALREADY EXIST! IT WONT WORK IF THESE FILES ARE NOT PRESENT!!
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {

        try {
            File fobj = new File("words.txt");//1)creates a file pointer to file
            Scanner fileReader = new Scanner(fobj);//3)creates a scanner object for the file pointer
            File fobj1 = new File("wordssmall.txt");
            while (fileReader.hasNextLine()) {// 4) checks whether file has next line
                String fileData = fileReader.nextLine();//5) creates a string and stores the file data into it
                fileData = fileData.toLowerCase(Locale.ROOT);
                try {
                    FileWriter fr = new FileWriter("wordssmall.txt",true);
                    fr.write(fileData);
                    fr.write("\n");
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                //System.out.println(fileData);//6)prints the string fD onto screen
            }
        }catch (FileNotFoundException e) {// exception handling while reading from file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

