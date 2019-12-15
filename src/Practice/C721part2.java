package Practice;

import java.io.*;
import java.util.*;

public class C721part2 {
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

    static class Graph{
        int vertices;
        ArrayList[] edges;
        Map<Integer,Integer> parent;
        Map<Pair<Integer,Integer>,Integer> map;
        static int last;
        static int usedTime;
        Graph(int vertices){
            this.vertices = vertices;
            last = vertices;
            parent = new HashMap<>();
            map = new HashMap<>();
            edges = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edges[i] = new ArrayList<Pair<Integer,Integer>>();
            }
        }

        void addEdge(int a,int b,int c){
            edges[a].add(new Pair<>(b,c));
            map.put(new Pair<>(a,b),c);
        }

        void DFS(){
            boolean[] visited = new boolean[vertices+1];
            DFSutil(visited,1);

        }
        private void DFSutil(boolean[] visited,int v){
            visited[v] = true;
            Iterator<Pair<Integer,Integer>> iterator = edges[v].listIterator();
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                if(!visited[pair.a]){
                    parent.put(pair.a,v);
                    DFSutil(visited,pair.a);
                }
            }
        }

    }

    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int v = Integer.parseInt(s1[0]);
        int edge = Integer.parseInt(s1[1]);
        int time  = Integer.parseInt(s1[2]);
        Graph graph = new Graph(v);

        for(int i=0;i<edge;i++){
            s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            graph.addEdge(a,b,c);
        }


    }


}
