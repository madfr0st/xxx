package xxx;

import java.io.*;

public class b1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        int[] given = new int[size];
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }
        int[] positive = new int[size];
        int[] negative = new int[size];
        if(given[0]>0){
            positive[0]++;
        }
        else{
            negative[0]++;
        }
        for(int i=1;i<size;i++){
            if (given[i]>=0){
                positive[i] = positive[i-1]+1;
                negative[i] = negative[i-1]+1;
            }
            else{

                positive[i] = negative[i-1]+positive[i-1];
                negative[i] = positive[i-1]+1+negative[i-1];

            }
        }
        System.out.println(negative[size-1]+" "+positive[size-1]);
    }
}
