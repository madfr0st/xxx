package Practice;

import java.io.*;
import java.util.ArrayList;

public class C1266 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int rows = Integer.parseInt(s1[0]);
        int colomns = Integer.parseInt(s1[1]);

        int count  = 1;
        int[][] ans = new int[rows+1][colomns+1];

        if(rows<colomns) {

            for (int i = 1; i < rows + 1; i++) {
                ans[i][0] = count;
                count++;
            }

            for (int i = 1; i < colomns + 1; i++) {
                ans[0][i] = count;
                count++;
            }
        }
        else{
            for (int i = 1; i < colomns + 1; i++) {
                ans[0][i] = count;
                count++;
            }

            for (int i = 1; i < rows + 1; i++) {
                ans[i][0] = count;
                count++;
            }
        }





        for(int i=1;i<rows+1;i++){
            for (int j=1;j<colomns+1;j++) {
                ans[i][j] = ans[i][0]*ans[0][j];
            }
        }

        if(rows==1 && colomns==1){
            System.out.println(0);
        }
        else {

            for (int i = 1; i < rows + 1; i++) {
                for (int j = 1; j < colomns + 1; j++) {
                    out.write(ans[i][j] + " ");
                }
                out.write("\n");
            }

            out.flush();
        }

    }
}
