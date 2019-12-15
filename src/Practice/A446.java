package Practice;

import java.io.*;

public class A446 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());

        if(size>=3) {
            int[] given = new int[size];
            String[] s1 = inp.readLine().split(" ");


            int[] dp = new int[size];
            int[] dp1 = new int[size];
            boolean used  = false;
            boolean blank = false;


            int maxlen = 1;

            for (int i = 0; i < size; i++) {
                given[i] = Integer.parseInt(s1[i]);
                dp[i] = 1;
                dp1[i] = 1;
            }

            for (int i = 1; i < size; i++) {
                if (given[i - 1] < given[i]) {
                    dp[i] = dp[i - 1] + 1;
                    maxlen = Math.max(maxlen,dp[i]);
                }
                if(given[size-1-i]<given[size-i]){
                    dp1[size-1-i] = dp1[size-i] + 1;
                }
            }
            if(maxlen<size){
                maxlen++;
            }
            int max = maxlen;
            for (int i = 2; i < size; i++) {
                if(given[i-2]<given[i]-1){
                    max = Math.max(max,dp[i-2]+dp1[i]+1);
                }
            }
            //print(dp);
            //print(dp1);

           // System.out.println(maxlen);
            System.out.println(max);

        }
        else{
            System.out.println(size);
        }


    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
