package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class B1284 {
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
            return getV().compareTo(o.getV());
        }
        private U getU() {
            return a;
        }
        private V getV() {
            return b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        ArrayList<Pair<Integer,Integer>> given = new ArrayList<>();
        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int min = Integer.MAX_VALUE;
            int max = 0;
            boolean self = false;

            for(int j=0;j<a;j++){
                int b = Integer.parseInt(s1[1+j]);
                max = Integer.max(max,b);
                min = Integer.min(min,b);
                if(min<b){
                    self = true;
                }
            }
            if(self){
                count++;
            }
            given.add(new Pair<>(min,max));
        }
        list.add(count);
        Collections.sort(given);

        for(int i=0;i<size;i++){
            int min = given.get(i).a;
            Pair<Integer,Integer> pair = new Pair<>(0,min);
            int index = Collections.binarySearch(given,pair);
            System.out.println(index);
            boolean self = false;
            if(index<0){
                index = -index-1;
            }
            while (index<size-1){
                if(given.get(index).b>min){
                    break;
                }
                else{
                    index++;
                }
            }
            System.out.println(index);
            list.add(size-index);
        }

        System.out.println(given);
        System.out.println(list);


    }
}
