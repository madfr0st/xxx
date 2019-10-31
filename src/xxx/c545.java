package xxx;

import java.io.*;

public class c545 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[][] dp = new int[size][3];
        int[][] given = new int[size][2];
        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            given[i][0] = a;
            given[i][1] = b;
        }

        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for(int i=1;i<size;i++){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
            //left
            if(given[i-1][0]<given[i][0]-given[i][1]){
                dp[i][1] = Math.max(dp[i-1][0]+1,dp[i-1][1]+1);
                if(given[i-1][0]+given[i-1][1]<given[i][0]-given[i][1]){
                    dp[i][1] = Math.max(dp[i-1][2]+1,dp[i][1]);
                }
            }
            else{
                dp[i][1] = dp[i][0];
            }
            //right
            if(i<size-1) {
                if (given[i + 1][0] > given[i][0] + given[i][1]) {
                    dp[i][2] = Math.max(dp[i - 1][0] + 1, Math.max(dp[i - 1][1]+1, dp[i - 1][2] + 1));
                } else {
                    dp[i][2] = dp[i][0];
                }
            }
            else{
                dp[i][2] = Math.max(dp[i - 1][0] + 1, Math.max(dp[i - 1][1]+1, dp[i - 1][2] + 1));
            }
        }
        int max = Math.max(dp[size-1][0],Math.max(dp[size-1][1],dp[size-1][2]));
        System.out.println(max);
        print(dp);
    }
    static void print(int[][] booleans){
        for(int j=0;j<booleans.length;j++) {
            for (int i = 0; i < booleans[0].length; i++) {
                System.out.print(booleans[j][i] + " ");
            }
            System.out.println();
        }
    }
}
