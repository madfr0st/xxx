package xxx;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class C165 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(inp.readLine());
        String[] given = inp.readLine().split("");
        int size = given.length;
        int[] dp = new int[size];
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            if(given[i].equals("1")){
                count++;
            }
            dp[i] = count;
            if(map.containsKey(count)){
                int a = map.get(count);
                a++;
                map.put(count,a);
            }
            else{
                map.put(count,1);
            }
        }

        long[] copy = new long[count+1];
        for(int i=0;i<=count;i++){
            copy[i] = map.getOrDefault(i, 0);
        }
        copy[0]++;
        int a = 0;
        long ans = 0;
       // System.out.println(map);
        while (a+k<=count){
            if(a+k>a) {
                ans = ans + copy[a] * copy[a + k];
            }
            else{
                long c = copy[a]-1;
                ans = ans+ ((c+1)*c)/2;

            }
            a++;
        }
        System.out.println(ans);


    }
}
