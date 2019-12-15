package Practice;

import java.io.*;

public class D49 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1  = inp.readLine().split("");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }
        int[][] dp = new int[size][size];
        int[][][] mod = new int[size][size][2];
        for(int i=0;i<size;i++){
            dp[i][i] = 0;
            mod[i][i][0] = given[i];
            mod[i][i][1] = given[i];
        }



        for(int i=1;i<size;i++){

            for(int j=0;j<size-i;j++){
                dp[j][j + i] = Integer.MAX_VALUE;
                for(int k=0;k<i;k++) {

                    if(mod[j][j+k][1]==mod[j+k+1][j+i][0]){
                        int a = Math.min(k+1,i-k+1);

                        int x = a;

                        if(a%2==1) {
                            a = a / 2 + 1;
                        }
                        else{
                            a = a/2;
                        }

                        dp[j][j + i] = Math.min(dp[j][j+k]+dp[j+1+k][j+i]+a,dp[j][j+i]);
                        if(dp[j][j + i] == dp[j][j+k]+dp[j+1+k][j+i]+a){
                            if(x==dp[j][j+k]) {
                                if (mod[j][j + k][0] == 0) {
                                    mod[j][j + i][0] = 1;
                                } else {
                                    mod[j][j + i][0] = 0;
                                }
                                mod[j][j + i][1] = mod[j+1+k][j+i][1] ;
                            }
                            else{
                                if(mod[j+1+k][j+i][1]==0) {
                                    mod[j][j+i][1] = 1;
                                }
                                else{
                                    mod[j][j+i][1] = 0;
                                }
                                mod[j][j + i][1] = mod[j][j+k][0] ;
                            }
                        }

                       // print(dp);

                    }
                    else{
                        dp[j][j + i] = Math.min(dp[j][j+k]+dp[j+1+k][j+i],dp[j][j+i]);
                        if(dp[j][j+i]==dp[j][j+k]+dp[j+1+k][j+i]){
                            mod[j][j+i][0] = mod[j][j+k][0];
                            mod[j][j+i][1] = mod[j+1+k][j+1][1];
                        }
                    }

                }

            }
        }

        print(dp);
        System.out.println(dp[0][size-1]);

    }
    static void print(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
