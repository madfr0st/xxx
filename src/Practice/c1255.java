package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class c1255 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(inp.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[size];
        Set<Integer> one = new HashSet<>();
        Set<Integer> two = new HashSet<>();
        Set<Integer> three = new HashSet<>();

        int[][] given = new int[size-2][3];

        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            count[a-1]++;
            count[b-1]++;
            count[c-1]++;
            given[i][0] = a;
            given[i][1] = b;
            given[i][2] = c;
        }

        for(int i=0;i<size;i++){
            if(count[i]==1){
                one.add(i+1);
            }
            if(count[i]==2){
                two.add(i+1);
            }
            if(count[i]==3){
                three.add(i+1);
            }
        }

        int x=0,y=0,z=0;
        int a=0,b=0,c=0;

        for(int i=0;i<size-2;i++){




        }





    }
}
