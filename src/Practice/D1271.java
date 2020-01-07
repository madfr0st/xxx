package Practice;

import java.io.*;
import java.util.*;

public class D1271 {
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
            return -(getV().compareTo(o.getV()));
        }
        private U getU() {
            return a;
        }
        private V getV() {
            return b;
        }
    }



    static class Graph{
        int vertices;
        int[] dp;
        ArrayList[] edge;
        Graph(int vertices){
            this.vertices = vertices;
            edge = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edge[i] = new ArrayList<Pair<Integer,Integer>>();
            }
        }
        void addEdge(int a,int b,int c){
            edge[a].add(new Pair<>(b,c));
        }
        void setDP(int[] dp){
            this.dp = dp;
        }
        void solve(){
            PriorityQueue<Pair<Pair<Integer,Integer>,Integer>> priorityQueue = new PriorityQueue<>();
            Set<Integer> used = new HashSet<>();
            print(dp);
            for(int i=0;i<vertices;i++){
                int a = dp[i];
                if(a>0){
                    Iterator<Pair<Integer,Integer>> iterator = edge[i+1].listIterator();
                    while (iterator.hasNext()){
                        Pair<Integer,Integer> pair = iterator.next();
                        priorityQueue.add(new Pair<>(new Pair<>(i+1,pair.a),pair.b));
                    }
                }
            }

            int count = 0;
            int ans = 0;
            boolean check = false;
            while (priorityQueue.size()>0){
                Pair<Pair<Integer,Integer>,Integer> pair = priorityQueue.poll();

                if(!used.contains(pair.a.b)){
                    System.out.println(pair);
                    if(dp[pair.a.a-1]>0){
                        for(int i=pair.a.a-1;i<vertices;i++){
                            dp[i]--;
                            if(dp[i]<0){
                                check = true;
                            }
                        }
                        if(check){
                            for(int i=pair.a.a-1;i<vertices;i++){
                                dp[i]++;
                            }
                            check = false;
                            System.out.println(pair);
                        }
                        else{

                            ans+=pair.b;
                            count++;
                            used.add(pair.a.b);
                        }
                    }
                    print(dp);
                }
            }
            System.out.println(ans);
            System.out.println(used);

        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int castles = Integer.parseInt(s1[0]);
        int portals = Integer.parseInt(s1[1]);
        int army = Integer.parseInt(s1[2]);
        Graph graph = new Graph(castles);

        int[][] given = new int[castles][3];
        int sum = army;
        boolean ans = true;
        for(int i=0;i<castles;i++){
            s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);

            given[i][0] = a;
            given[i][1] = b;
            given[i][2] = c;
            graph.addEdge(i+1,i+1,c);
            if(sum<a){
                ans = false;
            }
            sum+=b;

        }

        if(ans){



            for(int i=0;i<portals;i++){
                s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                graph.addEdge(a,b,given[b-1][2]);
            }

            int[] dp = new int[castles];
            int min = sum;
            dp[castles-1] = sum;
            sum -= given[castles-1][1];
            for(int i=castles-2;i>=0;i--){
                min = Math.min(min,sum-given[i+1][0]);
                dp[i] = min;
                sum -= given[i][1];
            }
            graph.setDP(dp);
            graph.solve();
        }
        else {
            System.out.println(-1);
        }

    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
