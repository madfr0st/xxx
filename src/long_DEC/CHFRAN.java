package long_DEC;

import java.io.*;
import java.util.*;

public class CHFRAN {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {

            int size = Integer.parseInt(inp.readLine());

            int[][] given = new int[size][2];
            ArrayList<Integer> all = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            Set<Integer> left = new HashSet<>();
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            Map<Integer,Integer> mapLeft = new HashMap<>();
            Map<Integer,Integer> mapRight = new HashMap<>();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<size;i++){
                String[] s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                given[i][0] = a;
                given[i][1] = b;
                if(!set.contains(a)){
                    set.add(a);
                    all.add(a);
                    left.add(a);
                }
                if(!right.contains(b)){
                    right.add(b);
                    if(!set.contains(b)) {
                        all.add(b);
                    }
                    set.add(b);
                    map.put(b,lists.size());
                    lists.add(new ArrayList<>());
                    lists.get(lists.size()-1).add(a);
                }
                else{
                    lists.get(map.get(b)).add(a);
                }
                if(mapLeft.containsKey(a)){
                    mapLeft.put(a,mapLeft.get(a)+1);
                }
                else{
                    mapLeft.put(a,1);
                }
                if(mapRight.containsKey(b)){
                    mapRight.put(b,mapRight.get(b)+1);
                }
                else{
                    mapRight.put(b,1);
                }
            }
            //System.out.println(all);
            Collections.sort(all);
            size = all.size();

            int[] dp = new int[size];
            Map<Integer,Integer> index = new HashMap<>();


            int active = 0;
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> ans = new ArrayList<>();
            boolean zero = false;
            int start = 0;
            int[] dp1 = new int[size];
            for(int i=0;i<size;i++){
                index.put(all.get(i),i);
                int a = 0;
                int b = 0;
                if(mapRight.containsKey(all.get(i))){
                    a = -mapRight.get(all.get(i));
                }
                if(mapLeft.containsKey(all.get(i))){
                    b = mapLeft.get(all.get(i));
                }
                active += b;
                dp[i] = active;

                b = a;
                start +=b;
                if(mapLeft.containsKey(all.get(i))){

                }

                if(mapRight.containsKey(all.get(i))){
                    //System.out.println(all.get(i));
                    a = map.get(all.get(i));
                    ArrayList<Integer> list = lists.get(a);
                    Iterator<Integer> iterator = list.listIterator();
                    while (iterator.hasNext()){
                        int n = iterator.next();
                        int l = index.get(n);
                        l = dp[l];
                        ans.add(Math.max(l,active));

                        min = Math.min(ans.get(ans.size() - 1), min);

                    }
                }
                active += b;
                if(i<size-1) {
                    if (active == 0) {
                        zero = true;
                        //break;
                    }
                }
            }

            print(dp);
            System.out.println(ans);
            if(!zero) {
                if (min == ans.size()) {
                    System.out.println(-1);
                } else {
                    System.out.println(min - 1);
                }
            }
            else{
                System.out.println(0);
            }


        }
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
