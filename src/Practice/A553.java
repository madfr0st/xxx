package Practice;

import java.io.*;

public class A553 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        int max = 0;
        int sum = 0;

        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(inp.readLine());
            max = Math.max(given[i],max);
            sum += given[i];
        }

        int[][] dp = new int[size][max];
        for(int i=0;i<size;i++){
            dp[i][0] = 1;
        }
        int count = size;

        for(int i=sum;i>0;i--){

            for(int j=count;j<=size;j++){

                for(int k=1;k<given[j-1];k++){


                    dp[j][k] = dp[j][k] + dp[j][k-1] + 1;


                }

            }

            count--;
            if(count<=0){
                count = 1;
            }

        }






    }
}
