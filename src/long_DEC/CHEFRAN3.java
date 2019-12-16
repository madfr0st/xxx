package long_DEC;

import java.io.*;
import java.util.*;

public class CHEFRAN3 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {

            int size = Integer.parseInt(inp.readLine());
            int totalSets = size;
            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> all = new ArrayList<>();

            int[] countleft = new int[1000001];
            int[] countright = new int[1000001];
            int[] givena = new int[size];
            int[] givenb = new int[size];
            int max = 0;

            for (int i = 0; i < size; i++) {
                String[] s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);

                givena[i] = a;
                givenb[i] = b;
                max = Math.max(max, b);

                set.add(a);
                set.add(b);
                if (max < 1000002) {
                    countleft[a]++;
                    countright[b]++;
                }

            }
            Iterator<Integer> iterator = set.iterator();
            for (int i = 0; i < set.size(); i++) {
                all.add(iterator.next());
            }
            Collections.sort(all);
            if (max < 1000001) {


                if (size > 1) {
                    int[] dpLeft = new int[all.size()];
                    int[] dpRight = new int[all.size()];

                    int closedLeft = 0;
                    int closedRight = 0;

                    size = all.size();
                    for (int i = 0; i < size; i++) {

                        int a = all.get(i);
                        int b = all.get(size - 1 - i);

                        closedLeft += countright[a];
                        dpLeft[i] = closedLeft;


                        closedRight += countleft[b];
                        dpRight[size - 1 - i] = closedRight;
                    }

                    long ans = Long.MAX_VALUE;
                    for (int i = 1; i < size; i++) {
                        long a = dpLeft[i - 1];
                        long b = dpRight[i];
                        if (a > 0 && b > 0) {
                            long active = totalSets - a - b;
                            ans = Math.min(active, ans);
                        }
                    }
                    if (ans == Long.MAX_VALUE) {
                        out.write(-1 + "\n");
                    } else {
                        out.write(ans + "\n");
                    }
                } else {
                    out.write(-1 + "\n");
                }
            }
            else{
                HashMap<Integer,Integer> mapStart = new HashMap<>();
                HashMap<Integer,Integer> mapFinish = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    int a = givena[i];
                    int b = givenb[i];
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
                    long[] dpLeft = new long[all.size()];
                    long[] dpRight = new long[all.size()];

                    int closedLeft = 0;
                    int closedRight = 0;

                    size = all.size();
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

                    long ans = Long.MAX_VALUE;
                    for (int i = 1; i < size; i++) {
                        long a = dpLeft[i - 1];
                        long b = dpRight[i];
                        if (a > 0 && b > 0) {
                            long active = totalSets - a - b;
                            ans = Math.min(active, ans);
                        }

                    }

                    if (ans == Long.MAX_VALUE) {
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
