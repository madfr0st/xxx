package long_DEC;

import java.io.*;
import java.util.*;

public class STICNOT {
    static class Pair<U extends Comparable<U>, V extends Comparable<V>>
        implements Comparable<Pair<U,V>>{

        public final U a;
        public final V b;

        Pair(U a, V b) {
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
         static int vertices;
        ArrayList[] edges;


        Graph(int vertices){
            this.vertices = vertices;
            edgesValue = new ArrayList<>();
            degree = new int[vertices+1];
            edges = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edges[i] = new ArrayList<Integer>();
            }
        }

        void addEdge(int a,int b){
            edges[a].add(b);
            edges[b].add(a);

            degree[a] = edges[a].size();
            degree[b] = edges[b].size();

        }
    }
    static int[] degree;
    static ArrayList<Integer> edgesValue;
    static ArrayList<Integer> verticesValue;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++) {
            edgesValue = new ArrayList<>();
            verticesValue = new ArrayList<>();
            int vertices = Integer.parseInt(inp.readLine());
            Graph graph = new Graph(vertices);

            for (int i = 0; i < vertices-1; i++) {
                String[] s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                int c = Integer.parseInt(s1[2]);
                edgesValue.add(c);
                graph.addEdge(a, b);
            }

            String[] s1 = inp.readLine().split(" ");
            for(int i=0;i<vertices;i++){
                verticesValue.add(Integer.parseInt(s1[i]));
            }

            Collections.sort(edgesValue);
            Collections.sort(verticesValue);

            PriorityQueue<Pair<Integer,Integer>> pairPriorityQueue = new PriorityQueue<>();

            for(int i=1;i<=vertices;i++){
                Pair<Integer,Integer> pair = new Pair<>(degree[i],i);
                pairPriorityQueue.add(pair);
            }

            Set<Integer> used = new HashSet<>();
            ArrayList<Pair> list = new ArrayList<>();

            while (pairPriorityQueue.size()>0 && used.size()<vertices){
                Pair<Integer,Integer> pair = pairPriorityQueue.poll();
                if(!used.contains(pair.b)){
                    list.add(pair);
                    used.add(pair.b);
                    Iterator<Integer> iterator = graph.edges[pair.b].listIterator();
                    while (iterator.hasNext()){
                        int n = iterator.next();
                        if(!used.contains(n)){
                            degree[n]--;
                            pairPriorityQueue.add(new Pair<>(degree[n],n));
                        }
                    }
                }
            }

            //System.out.println(list);
            ArrayList<Integer> minimunEdgesValue = new ArrayList<>();
            int count = -1;
            int check = 0;
            int ans = 0;
            boolean[] visited = new boolean[list.size()];
            for(int i=0;i<list.size();i++){
                int d = (int) list.get(i).a;
                int v = (int) list.get(i).b;
                count += d;
                int min =edgesValue.get(count);
                /**use binary search here to BEAT TLE---------------
                 **/

                int index = Collections.binarySearch(verticesValue, min);

                if (index < 0) {
                    index = -index - 1;
                }

                if (index == vertices) {
                    break;
                } else {
                    while (index < vertices) {
                        if (!visited[index]) {
                            visited[index] = true;
                            ans++;
                            break;
                        } else {
                            index++;
                        }
                    }
                }

                if (index == vertices) {
                    break;
                }


            }
            out.write((vertices-ans)+"\n");
        }
        out.flush();
    }
}
