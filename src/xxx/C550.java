package xxx;

import java.io.*;
import java.util.ArrayList;

public class C550 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split("");
        int size = s1.length;
        int[] given = new int[size];
        boolean[][] dp = new boolean[size][8];
        int[][] ind = new int[size][8];
        ArrayList<ArrayList<Integer>[]>[] list = new ArrayList[size];
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
            dp[i][given[i]%8] = true;
        }
        //print(dp);
        for(int i=1;i<size;i++){
            for(int j=0;j<8;j++){
                dp[i][(j*10+given[i])%8] = dp[i][(j*10+given[i])%8] | dp[i-1][j];
                if(dp[i][(j*10+given[i])%8]){
                    ind[i][j]=given[i-1];
                }
                dp[i][(j)%8] = dp[i][(j)%8] | dp[i-1][j];
            }
        }
        boolean ans = false;
        for(int i=0;i<size;i++){
            if(dp[i][0]){
                ans = true;
            }
        }
        //print(dp);
        if(ans){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
    static void print(boolean[][] a){
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
