package Practice;

import java.io.*;

public class D1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        long[] given = new long[size];
        for(int i=0;i<size;i++){
            int a = Integer.parseInt(s1[i]);
            given[i] = a;
        }

        long black= 0;
        long white = 0;
        boolean alter = false;
        int[] rest = new int[size];
        for(int i=0;i<size;i++){
            long a = given[i]/2;
            if(alter){
                black+=a;
                white+=given[i]-a;
                alter = false;
            }
            else{
                alter = true;
                black+=given[i]-a;
                white+=a;

            }
        }


        System.out.println(Math.min(black,white));



    }
}
