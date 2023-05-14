package jumble;

import java.util.Scanner;

public class JumWordAlpha {
    public static void main(String[] args) {
        long start = System.nanoTime();//for timer
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the jumbled word : ");
        String jumbleWord = sc.next();//takes input for jumble word
        char [] jumCharArray = jumbleWord.toCharArray();//converts string to char array
        int []jumWordArray = new int[jumCharArray.length];//creates int array of length jumbleWord string

        for(int i=0;i<jumbleWord.length();i++){//for traversing from start to end in char
          //jumWordArray[i]=Character.getNumericValue(jumCharArray[i]);//converts char to int equivalent
            jumWordArray[i]=jumCharArray[i] - '0';//We can also use this method too!(subtracting from zero
            System.out.println(jumCharArray[i] + " " + jumWordArray[i]);
        }
        //BUBBLE SORTING
        int n = jumWordArray.length;
        int temp = 0;
        for(int i=0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (jumWordArray[j - 1] > jumWordArray[j]) {
                    //swap elements
                    temp = jumWordArray[j - 1];
                    jumWordArray[j - 1] = jumWordArray[j];
                    jumWordArray[j] = temp;
                }
            }
        }

        System.out.println("Sorted Char Array\n");
        for(int i=0;i<jumbleWord.length();i++){
            jumCharArray[i]=(char)(jumWordArray[i] + '0');//converts back to char after getting sorted
            System.out.println(jumCharArray[i] + " " + jumWordArray[i]);//prints the sorted CHAR array
        }

	long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Elapsed Time : " + (elapsedTime/1000000000)+ " sec.\n");
    }
}