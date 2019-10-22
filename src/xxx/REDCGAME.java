package xxx;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class REDCGAME  {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++) {
            String[] s1 = inp.readLine().split(" ");
            int size = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            String[] s2 = inp.readLine().split(" ");
            for(int i=0;i<size;i++){
                int a = Integer.parseInt(s2[i]);
                if(a<=k){
                    sum+=a;
                }
                else{
                    list.add(a-k);
                    sum+=k;
                }
            }
            Collections.sort(list);
            int big = list.get(list.size()-1);
            list.remove(list.size()-1);
            int half = 0;
            for(int i=0;i<list.size();i++){
                half+=list.get(i);
            }
            half = half/2;
            int[][] dp = new int[list.size()][list.size()];
            int min = Integer.MAX_VALUE;
            for(int i=0;i<list.size();i++){
                for(int j=0;j<list.size();j++){

                }
            }

        }
        out.flush();
    }
}
