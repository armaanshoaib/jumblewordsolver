package Jumble;

import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

//JUMBLE_V1_1
// ADDED WHILE LOOP
// WORKS WITH CAPITAL LETTERS IN FILE
// DISPLAYS "NOT FOUND" WHEN ANSWER NOT FOUND


public class JumbleWordSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String jumbleWord = "";
            System.out.println("Enter the jumbled word : ");
            System.out.println("Enter 0 (zero) to exit !");
             jumbleWord = sc.next();//takes input for jumble word
            if(jumbleWord.equals("0")){
                break;
            }
            jumbleWord = jumbleWord.toLowerCase();
            char[] jumCharArray = jumbleWord.toCharArray();//converts string to char array
            int[] jumWordArray = new int[jumCharArray.length];//creates int array of length jumbleWord string

            for (int i = 0; i < jumbleWord.length(); i++) {//for traversing from start to end in char
//          jumWordArray[i]=Character.getNumericValue(jumCharArray[i]);//converts char to int equivalent
                jumWordArray[i] = jumCharArray[i] - '0';//converts char to int by SUBTRACTING from zero
                System.out.println(jumCharArray[i] + " " + jumWordArray[i]);
            }
            //BUBBLE SORTING
//        int n = jumWordArray.length;
//        int temp;
//        for(int i=0; i < n; i++) {
//            for (int j = 1; j < (n - i); j++) {
//                if (jumWordArray[j - 1] > jumWordArray[j]) {
//                    //swap elements
//                    temp = jumWordArray[j - 1];
//                    jumWordArray[j - 1] = jumWordArray[j];
//                    jumWordArray[j] = temp;
//                }
//            }
//        }
            Arrays.sort(jumWordArray);

            System.out.println("\nSorted Char Array\n");
            for (int i = 0; i < jumbleWord.length(); i++) {
                jumCharArray[i] = (char) (jumWordArray[i] + '0');//converts back to char after getting sorted by ADDING zero
                System.out.println(jumCharArray[i] + " " + jumWordArray[i]);//prints the sorted CHAR array
            }
            System.out.println("------------------------");
            boolean wordFound = false;
            float start = System.nanoTime();//for timer
            try {// fobj(file-pointer) requires a try and catch block!
                File fobj = new File("D:/Java/Jumble/words.txt");//creates a file pointer to file
                Scanner fileReader = new Scanner(fobj);//creates a scanner object for the file pointer


                //----------------------------------------------------------------------------
                while (fileReader.hasNextLine()) {// checks whether file has next line
                    String fileData = fileReader.nextLine();// creates a string and stores the file data into it
                    if (Objects.equals(fileData, "")) {//EOF
                        break;
                    }

                    char ch = jumCharArray[0];

                    if (fileData.length() == jumbleWord.length()) {
                        //to reduce time we choose words that have length equal to jumbled word
                        int[] posAnsArray = new int[fileData.length()];//creates an int array of size  string in sample to store ascii vals
                        fileData = fileData.toLowerCase();
                        char[] posAns = fileData.toCharArray();//converts fileData string to char array
                        for (int x = 0; x < posAns.length; x++) {
                            posAnsArray[x] = posAns[x] - '0';
                        }
                        //BUBBLE SORTING fileData char array(posAnsArray)
                        int temp1;
                        int num = posAns.length;
                        for (int iter = 0; iter < num; iter++) {
                            for (int j = 1; j < (num - iter); j++) {
                                if (posAnsArray[j - 1] > posAnsArray[j]) {
                                    //swap elements
                                    temp1 = posAnsArray[j - 1];
                                    posAnsArray[j - 1] = posAnsArray[j];
                                    posAnsArray[j] = temp1;
                                }
                            }
                        }
                        //converting back to char from int array after getting sorted by ADDING zero
                        for (int al = 0; al < posAns.length; al++) {
                            posAns[al] = (char) (posAnsArray[al] + '0');
                        }
                        int match = 0;
                        //PRINTS THE JUMBLED WORD IF IT IS IN THE WORDS.TXT
                        for (int charMatch = 0; charMatch < posAns.length; charMatch++) {
                            if (posAns[charMatch] == jumCharArray[charMatch]) {
                                match++;
                            }
                        }
                        if (match == posAns.length) {
                            System.out.println(fileData);
                            wordFound = true;
                        }
                        // i++;//advances index of jumCharArray
                    }

                }
            } catch (FileNotFoundException e) {// exception handling while reading from sample file
                System.out.println(e);
            }
            if (!wordFound) {
                System.out.println("No Words Found!");
            }

            float end = System.nanoTime();
            float elapsedTime = end - start;
            System.out.println("\nElapsed Time : " + (elapsedTime / 1000000000) + " sec.\n");
        }
    }
}
