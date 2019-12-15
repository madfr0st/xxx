package Practice;



import java.io.*;
import java.util.*;

public class D4 {
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
            if(getU().compareTo(o.getU())==0){
                return getV().compareTo(o.getV());
            }
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

        Map<Pair<Integer,Integer>,Integer> map = new HashMap<>();
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int card_width = Integer.parseInt(s1[1]);
        int card_height = Integer.parseInt(s1[2]);

        ArrayList<Pair<Integer,Integer>> given = new ArrayList();
        for(int i=0;i<size;i++){
            s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            map.put(new Pair<>(a,b),i+1);
            if(a>card_width){
                if(b>card_height){
                    given.add(new Pair<>(a,b));
                }
            }
        }
        Collections.sort(given);
        //System.out.println(given);
        if(given.size()>0) {
            int[] dp = new int[given.size()];
            size = given.size();
            dp[0] = 1;
            int max = 1;
            int index = 0;
            for (int i = 1; i < size; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (given.get(j).a < given.get(i).a) {
                        if (given.get(j).b < given.get(i).b) {
                            dp[i] = Math.max(dp[j] + 1, dp[i]);
                            if (dp[i] > max) {
                                max = dp[i];
                                index = i;
                            }
                        }
                    }
                }
            }
            System.out.println(max);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(map.get(given.get(index)));
            max--;
            for (int i = size - 1; i >= 0; i--) {
                if (dp[i] == max) {
                    if (given.get(i).a < given.get(index).a) {
                        if (given.get(i).b < given.get(index).b) {
                            max--;
                            list.add(map.get(given.get(i)));
                            index = i;
                        }
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                out.write(list.get(list.size() - 1 - i) + " ");
            }
            out.flush();
        }
        else{
            System.out.println(0);
        }
        //System.out.println(list);
    }

}
