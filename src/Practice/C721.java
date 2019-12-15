package Practice;

import java.io.*;
import java.util.*;

public class C721 {
    static class Tripple <U extends Comparable<U>, V extends Comparable<V>,W extends Comparable<W>>
            implements Comparable<Tripple<U,V,W>>{

        public final U a;
        public final V b;
        public final W c;

        private Tripple(U a, V b, W c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Tripple<?, ?, ?> tripple = (Tripple<?, ?, ?>) o;
            if (!a.equals(tripple.a))
                return false;
            if (!b.equals(tripple.b))
                return false;
            return c.equals(tripple.c);
        }

        @Override
        public int hashCode() {
            return 31 * a.hashCode() + b.hashCode() + c.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + "," + b + "," + c + ")";
        }

        @Override
        public int compareTo(Tripple<U, V, W> o) {
            return getW().compareTo(o.getW());
        }
        private U getU() {
            return a;
        }
        private V getV() {
            return b;
        }
        private W getW() {
            return c;
        }
    }
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
        Set<Integer> set;
        Map<Pair<Integer,Integer>,Integer> map;
        static int last;
        static ArrayList<Integer> mainPath;
        static int usedTime;
        Graph graph;
        Graph(int vertices){
            this.vertices = vertices;
            set = new HashSet<>();
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
            map.put(new Pair<>(b,a),c);
        }

        void setGraph(Graph graph){
            this.graph = graph;
        }

        void solve(int time) throws IOException{
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            graph.DFS();
            PriorityQueue<Tripple<Integer,Integer,Integer>> priorityQueue = new PriorityQueue<>();
            int restTime = time - usedTime;
            for(int i=0;i<mainPath.size();i++){
                int b = mainPath.get(i);
                Iterator<Pair<Integer,Integer>> iterator = edges[b].listIterator();
                while (iterator.hasNext()){
                    Pair<Integer,Integer> n = iterator.next();
                    if(!set.contains(n.a)){
                        priorityQueue.add(new Tripple<>(b,n.a,n.b));
                    }
                }
            }
            System.out.println(priorityQueue);
            while (priorityQueue.size()>0){

                Tripple<Integer,Integer,Integer> tripple = priorityQueue.poll();
                if(tripple.c*2<=restTime && (!set.contains(tripple.a) || !set.contains(tripple.b))){

                    restTime -= 2*tripple.c;
                    if (!set.contains(tripple.a)) {
                        Iterator<Pair<Integer, Integer>> iterator = edges[tripple.a].iterator();
                        while (iterator.hasNext()){
                            Pair<Integer,Integer> n = iterator.next();
                            if(!set.contains(n.a)){
                                priorityQueue.add(new Tripple<>(tripple.a,n.a,n.b));
                            }
                        }
                    }
                    if (!set.contains(tripple.b)) {
                        Iterator<Pair<Integer, Integer>> iterator = edges[tripple.b].iterator();
                        while (iterator.hasNext()){
                            Pair<Integer,Integer> n = iterator.next();
                            if(!set.contains(n.b)){
                                priorityQueue.add(new Tripple<>(tripple.b,n.a,n.b));
                            }
                        }
                    }
                    set.add(tripple.a);
                    set.add(tripple.b);
                }
                else if(tripple.c*2 > restTime){
                    break;
                }
            }
            System.out.println(set);
            System.out.println(restTime);
            mainPath.clear();
            graph.DFSans();
            out.write(mainPath.size()+"\n");
            for(int i=0;i<mainPath.size();i++){
                out.write(mainPath.get(i)+" ");
            }
            out.flush();
        }

        void DFSans(){
            boolean[] visited = new boolean[vertices+1];
            mainPath.add(1);
            DFSansutil(1,visited);
        }
        void DFSansutil(int v,boolean[] visited){
            visited[v] = true;
            Iterator<Pair<Integer,Integer>> iterator = edges[v].listIterator();
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                if(!visited[pair.a] && set.contains(pair.a)){
                    //System.out.println(pair);
                    parent.put(pair.a,v);
                    mainPath.add(pair.a);
                    DFSansutil(pair.a,visited);
                }
            }
        }

        void DFS(){
            boolean[] visited = new boolean[vertices+1];
            DFSutil(visited,1);
            mainPath = new ArrayList<>();
            mainPath.add(last);
            set.add(last);
            int at = last;
            while (true){
                int c = parent.get(at);
                mainPath.add(c);
                set.add(c);
                Pair<Integer,Integer> pair = new Pair<>(at,c);
                int d = map.get(pair);
                usedTime += d;
                at = c;
                if(c==1){
                    break;
                }
            }
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
        graph.setGraph(graph);
        graph.solve(time);

    }
}
