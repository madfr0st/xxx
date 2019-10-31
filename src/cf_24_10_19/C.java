package cf_24_10_19;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1]);

        int[][] given = new int[a][b];
        int[][][] dp = new int[a][b][4];
        int[][] c = new int[b][2];
        int[][] r = new int[a][2];

        for(int i=0;i<a;i++){
            String[] s2 = inp.readLine().split("");
            int count = 0;
            boolean once = true;
            for(int j=0;j<b;j++){
                dp[i][j][0] = 1;
                dp[i][j][1] = 1;
                dp[i][j][2] = 1;
                dp[i][j][3] = 0;
                if(s2[j].equals(".")){
                    given[i][j] = 0;
                }
                else{
                    if(once) {
                        r[i][0] = i;
                        once = false;
                    }
                    r[i][1]++;
                    given[i][j] = 1;
                }
            }
            r[i][1] = b-r[i][1];
        }
        for(int i=0;i<b;i++){
            boolean once = true;
            for(int j=0;j<a;j++){
                if(given[i][j]==1){
                    if(once) {
                        c[i][0] = i;
                        once = false;
                    }
                    c[i][1]++;
                }
            }
            c[i][1] = a-c[i][1];
        }
        long ans = 0;
        for(int i=1;i<a;i++){
            for(int j=1;j<b;j++){
                dp[i][j][0] = dp[i-1][j][0]+dp[i][j-1][0];
                dp[i][j][1] = dp[i-1][j][0];
                dp[i][j][2] = dp[i][j-1][0];
                dp[i][j][3] = 0;
                //if(r[i][1])
                if(r[i][0]>=i){
                    if(c[j][0]>=j){
                        if(c[j][1]<j){

                        }
                        else{

                        }
                    }
                    else{

                    }
                }
                else{

                }
            }
        }




    }
    static void print(int[] booleans){
        for(int i=0;i<booleans.length;i++){
            System.out.print(booleans[i]+" ");
        }
        System.out.println();
    }
    static void print(int[][] booleans){
        for(int i=0;i<booleans.length;i++){
            for(int ii=0;ii<booleans[0].length;ii++){
                System.out.print(booleans[i][ii]+" ");
            }
        }
        System.out.println();
    }
}

