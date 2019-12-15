package long_DEC;

import java.io.*;
import java.util.ArrayList;

public class BINADD {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++) {
            String[] s1 = inp.readLine().split("");
            String[] s2 = inp.readLine().split("");

            boolean hasOne = false;
            int size = Math.max(s1.length, s2.length);
            int[] A = new int[size];
            int[] B = new int[size];
            for (int i = 0; i < s1.length; i++) {
                A[size - 1 - i] = Integer.parseInt(s1[s1.length - 1 - i]);
            }
            for (int i = 0; i < s2.length; i++) {
                B[size - 1 - i] = Integer.parseInt(s2[s2.length - 1 - i]);
                if (B[size-1-i] == 1) {
                    hasOne = true;
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            int maxDiff = 0;
            int max = 0;
            boolean start = false;
            int count = 0;
            for (int i = 0; i < size; i++) {
                int a = A[size - 1 - i];
                int b = B[size - 1 - i];
                if (a == 1 && b == 1) {
                    if (start) {
                        list.add(count);
                        max = Math.max(max, count);
                    }
                    start = true;
                    count = 1;
                } else if (start) {
                    if (a == 1 && b == 0) {
                        count++;
                    }
                    if (a == 0 && b == 1) {
                        count++;
                    }
                    if (a == 0 && b == 0) {
                        start = false;
                        list.add(count);
                        max = Math.max(max, count);
                        count = 0;
                    }
                }
            }
            if(start){
                start = false;
                list.add(count);
                max = Math.max(max, count);
                count = 0;
            }
            if(hasOne){
                //System.out.println(max+1);
                max++;
                out.write(max+"\n");
            }
            else{
                //System.out.println("zero");
                out.write(0+"\n");
            }
        }
        out.flush();
    }
}
