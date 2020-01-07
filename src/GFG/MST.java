package GFG;

import java.io.*;
import java.util.*;

public class MST {

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
        // this varaible keeps the least cost edge
        static Pair<Pair<Integer,Integer>,Integer> minCostEdge;

        Graph(int vertices){
            minCostEdge = new Pair<>(new Pair<>(1,1),Integer.MAX_VALUE);
            this.vertices = vertices;
            edges = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edges[i] = new ArrayList<Pair<Integer,Integer>>();
            }
        }

        void addEdge(int a,int b,int weight){
            edges[a].add(new Pair<>(b,weight));
            edges[b].add(new Pair<>(a,weight)); // this line of code graph undirected
            if(weight<minCostEdge.b){
                minCostEdge = new Pair<>(new Pair<>(a,b),weight);
            }
        }

        void MST(){

            //priority queue for applying heap
            PriorityQueue<Pair<Pair<Integer,Integer>,Integer>> priorityQueue = new PriorityQueue<>();

            //adding all the connected vertices of MinCostEdge vertex A to PQ
            Iterator<Pair<Integer,Integer>> iterator = edges[minCostEdge.a.a].listIterator();
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                priorityQueue.add(new Pair<>(new Pair<>(minCostEdge.a.a,pair.a),pair.b));
            }

            //adding all the connected vertices of MinCostEdge vertex B to PQ
            iterator = edges[minCostEdge.a.b].listIterator();
            while (iterator.hasNext()){
                Pair<Integer,Integer> pair = iterator.next();
                priorityQueue.add(new Pair<>(new Pair<>(minCostEdge.a.b,pair.a),pair.b));
            }

            //set to check vertex is added or not
            Set<Integer> addedVertices = new HashSet<>();

            //set contains all the added edges and cost from source
            Set<Pair<Pair<Integer,Integer>,Integer>> addedEdges = new HashSet<>();

            //using greedy approach to find least costing edge to the GRAPH
            while (addedEdges.size()<vertices-1){

                //polling from priority queue
                Pair<Pair<Integer,Integer>,Integer> pair = priorityQueue.poll();

                //checking weather vertex A is added or not
                if(!addedVertices.contains(pair.a.a)){
                    addedVertices.add(pair.a.a);
                    addedEdges.add(pair);

                    //Adding all the connected vertices with vertex A
                    iterator = edges[pair.a.a].listIterator();
                    while (iterator.hasNext()){
                        Pair<Integer,Integer> pair1 = iterator.next();
                        priorityQueue.add(new Pair<>(new Pair<>(pair.a.a,pair1.a),pair1.b));
                    }
                }

                //checking weather vertex B is added or not
                if(!addedVertices.contains(pair.a.b)){
                    addedVertices.add(pair.a.b);
                    addedEdges.add(pair);

                    //Adding all the connected vertices with vertex B
                    iterator = edges[pair.a.b].listIterator();
                    while (iterator.hasNext()){
                        Pair<Integer,Integer> pair1 = iterator.next();
                        priorityQueue.add(new Pair<>(new Pair<>(pair.a.b,pair1.a),pair1.b));
                    }
                }
            }


            //printing MST
            Iterator<Pair<Pair<Integer,Integer>,Integer>> iterator1 = addedEdges.iterator();
            System.out.println("((A"+", "+"B)"+", "+"Cost)");
            while (iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }
    }

    public static void main(String[] args)throws IOException {

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

        //Appling MST
        graph.MST();
    }
}

