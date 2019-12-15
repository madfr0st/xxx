package Practice;

import java.io.*;
import java.util.*;

public class DIGJUMP {
    static class Graph{
        int vertices;
        ArrayList[] edge;
        Graph(int vertices){
            this.vertices = vertices;
            edge = new ArrayList[vertices+1];
            for(int i=0;i<=vertices;i++){
                edge[i] = new ArrayList<Integer>();
            }
        }

        void addEdge(int a,int b){
            edge[a].add(b);
            edge[b].add(a);
        }

        void BFS(int last){
            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer,Integer> map = new HashMap<>();
            int count = 0;
            boolean find = false;
            queue.add(1);
            map.put(1,0);
            boolean[] visited = new boolean[vertices+1];

            while (queue.size()>0){
                int a = queue.poll();
                visited[a] = true;
                Iterator<Integer> iterator = edge[a].listIterator();
                while (iterator.hasNext()){
                    int n = iterator.next();
                    if(n==last){
                        find = true;
                    }
                    if(!visited[n]){
                        visited[n] = true;
                        //System.out.print(n+" ");
                        map.put(n,map.get(a)+1);
                        queue.add(n);
                    }
                }
                count++;
                if(find){
                   break;
                }
            }

            //System.out.println();
            System.out.println(map.get(last));


        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split("");
        boolean[] used = new boolean[10];
        Map<Integer,Integer> parent = new HashMap<>();

        Graph graph = new Graph(s1.length);

        int a = Integer.parseInt(s1[0]);
        used[a] = true;
        parent.put(a,1);

        for(int i=1;i<s1.length;i++){
            int b = Integer.parseInt(s1[i]);

            if(used[b]){
                graph.addEdge(i+1,parent.get(b));
                graph.addEdge(i,i+1);
            }
            else{
                graph.addEdge(i,i+1);
                used[b] = true;
                parent.put(b,i+1);
            }

            a = b;

        }

        graph.BFS( s1.length );


    }
}
