package long_DEC;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class APAIRS {
    static class Pair<U extends Comparable<U>, V extends Comparable<V>>
            implements Comparable<Pair<U,V>>{

        public final U a;
        public final V b;

        private Pair(U a, V b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!a.equals(pair.a))
                return false;
            return b.equals(pair.b);
        }

        @Override
        public int hashCode() {
            return 31 * a.hashCode() + b.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }

        @Override
        public int compareTo(Pair<U, V> o) {
            return getU().compareTo(o.getU());
        }
        private U getU() {
            return a;
        }
        private V getV() {
            return b;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(inp.readLine());
        Map<Integer,Long> map = new HashMap<>();
        long ans = 0;
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                ans += value(i,j);
                map.put(i,ans);
            }
        }
        for (int t = 0; t < testCase; t++) {
            String[] s1 = inp.readLine().split(" ");

            long left = Long.parseLong(s1[0]);
            long right = Long.parseLong(s1[1]);

            ans = map.get((int)right)-map.get((int)left);
            ans%=1000000007;

            out.write(ans+"\n");
        }
        out.flush();
    }
    static int value(int a,int b){
        String[] s1 = Integer.toString(a).split("");
        String[] s2 = Integer.toString(b).split("");
        int size = Math.max(s1.length,s2.length);
        int[] aa = new int[size];
        int[] bb = new int[size];
        for(int i=0;i<s1.length;i++){
            aa[i] = Integer.parseInt(s1[i]);
        }
        for(int i=0;i<s2.length;i++){
            bb[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(aa);
        Arrays.sort(bb);
//        print(aa);
//        print(bb);
        int ans = 0;
        for(int i=0;i<size;i++){
            ans += Math.abs(aa[i]-bb[i]);
        }
        return ans;
    }
    static long[] appear(long a){
        long[] count = new long[10];
        for(int i=1;i<=a;i++){
            String[] s = Integer.toString(i).split("");
            for(int j=0;j<s.length;j++){
                count[Integer.parseInt(s[j])]++;
            }
        }
        return count;
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
