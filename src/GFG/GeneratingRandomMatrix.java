package GFG;


// A JAVA Program to generate test cases for
// matrix filled with random numbers
import java.io.*;
import java.util.Random;

public class GeneratingRandomMatrix {
    //the number of runs for the test data generated
    static int RUN = 5;

    //miminum range of random numbers
    static int lowerBound = 0;

    //maximum range of random numbers
    static int upperBound = 1000;

    //maximum size of colomn
    static int maxColomn = 10;

    //miminum size of colomn
    static int minColomn = 1;

    //minimum size of row
    static int minRow = 1;

    //maximum size of row
    static int maxRow = 10;

    public static void main (String[] args) throws IOException {

        // Uncomment the below line to store the test data in a file
        //BufferedWriter out = new BufferedWriter(new FileWriter(new File("D:\\test.txt")));

        Random random = new Random();

        for(int i=0;i<RUN;i++){

            int row = random.nextInt(maxRow-minRow)+minRow;
            int colomn = random.nextInt(maxColomn-minColomn)+minColomn;

            int[][] matrix = new int[row][colomn];

            System.out.println(row+" "+colomn);
            //out.write(row+" "+colomn+"\n");

            for(int j=0;j<row;j++) {
                for(int k=0;k<colomn;k++) {

                    int a = random.nextInt(upperBound - lowerBound) + lowerBound;
                    System.out.print(a + " ");

                    // Uncomment the below line to store the test data in a file
                    //out.write(a+" ");
                }
                System.out.println();
                // Uncomment the below line to store the test data in a file
                //out.write("\n");
            }
            System.out.println();
            // Uncomment the below line to store the test data in a file
            //out.write("\n");
        }
        // Uncomment the below line to store the test data in a file
        //out.flush();
    }
}
