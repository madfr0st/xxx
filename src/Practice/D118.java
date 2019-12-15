package Practice;

import java.io.*;

public class D118 {
    static int modulo = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int footMen = Integer.parseInt(s1[0]);
        int horseMen = Integer.parseInt(s1[1]);
        int k1 = Integer.parseInt(s1[2]);
        int k2 = Integer.parseInt(s1[3]);

        long[][][] dp = new long[footMen+1][horseMen+1][2];

        boolean once = false;

        for(int i=0;i<=footMen;i++){
            for(int j=0;j<=horseMen;j++){

                if(!once){
                    once = true;
                    dp[i][j][0] = 1;
                    dp[i][j][1] = 1;
                }
                else{

                    //System.out.println("S");
                    for(int k=1;k<=Math.min(i,k1);k++){
                        dp[i][j][0] += dp[i-k][j][1];
                        dp[i][j][0] %= modulo;
                    }
                    for(int k=1;k<=Math.min(j,k2);k++){
                        dp[i][j][1] += dp[i][j-k][0];
                        dp[i][j][1] %= modulo;
                    }
                }
            }
        }

        System.out.println((dp[footMen][horseMen][0]+dp[footMen][horseMen][1])%modulo);


    }
}
