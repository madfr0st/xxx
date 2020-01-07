package GFG;


// A JAVA Program to generate test cases for
// random number
import java.io.*;
import java.util.Random;

public class GeneratingRandomNumbers {

    //the number of runs for the test data generated
    static int requiredNumbers = 5;

    //miminum range of random numbers
    static int lowerBound = 0;

    //maximum range of random numbers
    static int upperBound = 1000;

    public static void main (String[] args) throws IOException {

        // Uncomment the below line to store the test data in a file
        //BufferedWriter out = new BufferedWriter(new FileWriter(new File("C:\\test.txt")));

        Random random = new Random();

        for(int i=0;i<requiredNumbers;i++){

            int a = random.nextInt(upperBound-lowerBound)+lowerBound;
            System.out.println(a);

            // Uncomment the below line to store the test data in a file
            //out.write(a+"\n");
        }
        // Uncomment the below line to store the test data in a file
        //out.flush();
    }
}
