package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class D161 {
    static class Graph{
        int vertices;
        ArrayList[] edge;
        ArrayList[] list;
        static int[] dist;
        static int count;
        static int k;
        Graph(int vertices){
            dist = new int[vertices+1];
            this.vertices = vertices;
            edge = new ArrayList[vertices+1];
            list = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edge[i] = new ArrayList<Integer>();
                list[i] = new ArrayList<Integer>();
            }
        }
        private void addEdge(int a,int b){
            edge[a].add(b);
            edge[b].add(a);
        }

        void DFS(int k){
            this.k = k;
            boolean[] visited = new boolean[vertices+1];
            int last = -1;
            for(int i=0;i<=vertices;i++){
                if(edge[i].size()==1){
                    last = i;
                    break;
                }
            }
            System.out.println(last);
            DFSutil(last,visited);
            System.out.println(count);

        }

        private void DFSutil(int a,boolean[] visited){
            visited[a] = true;
            Iterator<Integer> iterator = edge[a].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    DFSutil(n,visited);

                    dist[a] = dist[n]+1;
                    list[a].add(dist[a]);
                    if(dist[a]==k){
                        count += 1;
                        System.out.println(a+" "+n);
                    }

                }
            }
        }

        
    }



    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int a = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        Graph graph = new Graph(a);
        for(int i=0;i<a-1;i++){
            s1 = inp.readLine().split(" ");
            int c = Integer.parseInt(s1[0]);
            int d = Integer.parseInt(s1[1]);
            graph.addEdge(c,d);
        }
        graph.DFS(k);


    }
}
