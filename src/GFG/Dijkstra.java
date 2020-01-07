package GFG;



import java.io.*;
import java.util.*;

public class Dijkstra {

    //Pair class with implemented comparable
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

        //overriding so that objects in map could find the object key
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

    static class Graph{

        int vertices;
        ArrayList[] edges;

        Graph(int vertices){
            this.vertices = vertices;
            edges = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edges[i] = new ArrayList<Pair<Integer,Integer>>();
            }
        }

        void addEdge(int a,int b,int weight){
            edges[a].add(new Pair<>(b,weight));
            edges[b].add(new Pair<>(a,weight)); // this line of code graph undirected
        }

        void dijkstra(int source){

            //use of priotity queue as heap
            PriorityQueue<Pair<Integer,Integer>> priorityQueue = new PriorityQueue<>();

            //map to store vertex parent
            Map<Pair<Integer,Integer>,Integer> parent = new HashMap<>();

            //map to store cost of added vertices
            Map<Integer,Integer> cost = new HashMap<>();

            //set to check vertex is added or not
            Set<Integer> addedVertices = new HashSet<>();

            //set contains all the added edges and cost from source
            Set<Pair<Integer,Integer>> addedEdges = new HashSet<>();

            //Adding vertices from source to priority queue
            Iterator<Pair<Integer,Integer>> iterator = edges[source].listIterator();
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                priorityQueue.add(pair);
                parent.put(pair,source);
            }

            // initializing source vertex
            cost.put(source,0);
            addedVertices.add(source);
            addedEdges.add(new Pair<>(source,0));

            //using greedy approach to find least costing edge to add a vertex
            while (addedVertices.size()<vertices){

                //polling from priority queue
                Pair<Integer,Integer> pair = priorityQueue.poll();

                //checking weather vertex is added or not
                if(!addedVertices.contains(pair.a)){

                    //adding to the answer
                    addedVertices.add(pair.a);
                    addedEdges.add(pair);
                    cost.put(pair.a,pair.b);

                    //adding all the connected vertices of newly added vertex to priority queue
                    Iterator<Pair<Integer,Integer>> iterator1 = edges[pair.a].listIterator();
                    while (iterator1.hasNext()){
                        Pair<Integer,Integer> pair1 = iterator1.next();
                        if(!addedVertices.contains(pair1.a)) {

                            //adding parent cost and pusing in pririty queue
                            priorityQueue.add(new Pair<>(pair1.a,cost.get(pair.a)+pair1.b));
                        }
                    }
                }
            }


            //printing shortest distance from source
            iterator = addedEdges.iterator();
            System.out.println("verices"+"  "+"distance from source");
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                System.out.println(pair.a +"                "+pair.b);
            }

        }


    }

    public static void main(String[] args)throws IOException{

        //using buffer reader to take input
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        //reading input
        String[] s1 = inp.readLine().split(" ");
        int v = Integer.parseInt(s1[0]);
        int e = Integer.parseInt(s1[1]);

        //initializing graph
        Graph graph = new Graph(v);
        for(int i=0;i<e;i++){
            s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int weight = Integer.parseInt(s1[2]);
            graph.addEdge(a,b,weight);
        }

        //Appling Dijkstra
        graph.dijkstra(0);

    }


}
