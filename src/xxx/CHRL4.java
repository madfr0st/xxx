package xxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CHRL4 {
    static int modulo = 1000000007;
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> map = new HashMap<>();
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        int[] given = new int[size];
        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s2[i]);
        }
        if(size>1) {
            long dp[] = new long[size];
            dp[0] = given[0];
            map.put(0, 0);
            for (int i = 1; i < size; i++) {
                dp[i] = Long.MAX_VALUE;
                for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                    dp[i] = Math.min(dp[i], given[j]);
                    if (dp[i] == given[j]) {
                        map.put(i, j);
                    }
                }
            }
            //print(dp);
            long ans = (given[0] * given[size - 1]) % modulo;
            int check = size - 1;
            //System.out.println(map);
            while (true) {
                check = map.get(check);
                if (check == 0) {
                    break;
                }
                ans = (ans * given[check]) % modulo;
            }
            System.out.println(ans);
        }
        else{
            System.out.println(given[0]);
        }
    }
    static void print(long[] dp){
        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
}
