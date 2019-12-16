package long_DEC;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class TRY {
    static long constant = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {

            int size = Integer.parseInt(inp.readLine());
            int totalSets = size;

            ArrayList<Long> all = new ArrayList<>();
            HashSet<Long> set = new HashSet<>();
            HashMap<Long,Long> mapStart = new HashMap<>();
            HashMap<Long,Long> mapFinish = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String[] s1 = inp.readLine().split(" ");
                long a = Integer.parseInt(s1[0]);
                long b = Integer.parseInt(s1[1]);
                a*=constant;
                b*=constant;

                if (!set.contains(a)) {
                    set.add(a);
                    all.add(a);
                }
                if (!set.contains(b)) {
                    set.add(b);
                    all.add(b);
                }
                if (mapStart.containsKey(a)) {
                    mapStart.put(a, mapStart.get(a) + 1);
                } else {
                    mapStart.put(a, 1l);
                }
                if (mapFinish.containsKey(b)) {
                    mapFinish.put(b, mapFinish.get(b) + 1);
                } else {
                    mapFinish.put(b, 1l);
                }
            }



                //System.out.println(-1);
                out.write(-1+"\n");


        }
        out.flush();
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
