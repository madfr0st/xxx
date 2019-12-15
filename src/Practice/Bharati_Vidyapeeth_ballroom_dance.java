package Practice;

import java.io.*;
import java.util.*;

public class Bharati_Vidyapeeth_ballroom_dance {
    static class Graph{
        int vertices;
        Map<Integer,Integer> values;
        ArrayList[] edge;
        Graph(int vertices){
            values = new HashMap<>();
            this.vertices = vertices;
            edge = new ArrayList[vertices+1];

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> boys = new HashMap<>();
        Map<Integer,Integer> girls = new HashMap<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> G = new HashSet<>();
        ArrayList<Integer> listB = new ArrayList<>();
        ArrayList<Integer> listG = new ArrayList<>();

        int boysSize = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        int girlsSize = Integer.parseInt(inp.readLine());
        String[] s2 = inp.readLine().split(" ");

        for(int i=0;i<boysSize;i++){
            int a = Integer.parseInt(s1[i]);
            if(B.contains(a)){
               boys.put(a,boys.get(a)+1);
            }
            else{
                boys.put(a,1);
                B.add(a);
                listB.add(a);
            }
        }
        for(int i=0;i<girlsSize;i++){
            int a = Integer.parseInt(s2[i]);
            if(G.contains(a)){
                girls.put(a,girls.get(a)+1);
            }
            else{
                girls.put(a,1);
                G.add(a);
                listG.add(a);
            }
        }


    }
}
