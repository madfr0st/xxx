package long_DEC;

import java.io.*;
import java.util.*;

public class CHFRAN_2 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {

            int size = Integer.parseInt(inp.readLine());
            int totalSets = size;


                //int[][] given = new int[size][2];
                ArrayList<Integer> all = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                Map<Integer, Integer> mapStart = new HashMap<>();
                Map<Integer, Integer> mapFinish = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    String[] s1 = inp.readLine().split(" ");
                    int a = Integer.parseInt(s1[0]);
                    int b = Integer.parseInt(s1[1]);
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
                        mapStart.put(a, 1);
                    }
                    if (mapFinish.containsKey(b)) {
                        mapFinish.put(b, mapFinish.get(b) + 1);
                    } else {
                        mapFinish.put(b, 1);
                    }
                }
            if(size>1) {
                int[] dpLeft = new int[all.size()];
                int[] dpRight = new int[all.size()];

                int closedLeft = 0;
                int closedRight = 0;

                size = all.size();
                Collections.sort(all);   /**use merge sort*/
                //System.out.println(all);
                for (int i = 0; i < size; i++) {

                    int a = all.get(i);
                    int b = all.get(size - 1 - i);

                    if (mapFinish.containsKey(a)) {
                        closedLeft += mapFinish.get(a);
                        dpLeft[i] = closedLeft;
                    } else {
                        dpLeft[i] = closedLeft;
                    }

                    if (mapStart.containsKey(b)) {
                        closedRight += mapStart.get(b);
                        dpRight[size - 1 - i] = closedRight;
                    } else {
                        dpRight[size - 1 - i] = closedRight;
                    }
                }

                int ans = Integer.MAX_VALUE;
                for (int i = 1; i < size; i++) {
                    int a = dpLeft[i - 1];
                    int b = dpRight[i];
                    if (a > 0 && b > 0) {
                        int active = totalSets - a - b;
                        ans = Math.min(active, ans);
                    }

                }

                if (ans == Integer.MAX_VALUE) {
                    out.write(-1+"\n");
                    //System.out.println(-1);
                } else {
                    //System.out.println(ans);
                    out.write(ans+"\n");
                }
//            print(dpLeft);
//            print(dpRight);
            }
            else{
                //System.out.println(-1);
                out.write(-1+"\n");
            }

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
