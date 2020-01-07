package GFG;

// A JAVA Program to generate test cases for
// random Array

import java.io.IOException;
import java.util.Random;

public class GeneratingRandomArrays {

    //the number of runs for the test data generated
    static int RUN = 5;

    //miminum range of random numbers
    static int lowerBound = 0;

    //maximum range of random numbers
    static int upperBound = 1000;

    //miminum size of reqd array
    static int minSize = 10;

    //maximum size of reqd array
    static int maxSize = 20;

    public static void main (String[] args) throws IOException {

        // Uncomment the below line to store the test data in a file
        //BufferedWriter out = new BufferedWriter(new FileWriter(new File("C:\\test.txt")));

        Random random = new Random();

        for(int i=0;i<RUN;i++){

            int size = random.nextInt(maxSize-minSize)+minSize;
            int[] array = new int[size];

            System.out.println(size);
            //out.write(size+"\n");

            for(int j=0;j<size;j++) {
                int a = random.nextInt(upperBound - lowerBound) + lowerBound;
                System.out.print(a + " ");

                // Uncomment the below line to store the test data in a file
                //out.write(a+" ");
            }
            System.out.println();
            // Uncomment the below line to store the test data in a file
            //out.write("\n");
        }
        // Uncomment the below line to store the test data in a file
        //out.flush();
    }
}


