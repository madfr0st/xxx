package Practice;



import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindtheNext {
    static class DisjointSet {

        private Map<Integer, Node> map = new HashMap<>();

        static class Node {
            int data;
            Node parent;
        }

        /**
         * Create a set with only one element.
         */
        public void makeSet(int data) {
            Node node = new Node();
            node.data = data;
            node.parent = node;
            map.put(data, node);
        }

        public Node getNode(int c){
            return map.get(c);
        }

        /**
         * Combines two sets together to one.
         * Does union by rank
         *
         * @return true if data1 and data2 are in different set before union else false.
         */
        public boolean union(int data1, int data2) {
            Node node1 = map.get(data1);
            Node node2 = map.get(data2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            //if they are part of same set do nothing
            if (parent1.data == parent2.data) {
                return false;
            }

            //else whoever's rank is higher becomes parent of other
            if (parent1.data >= parent2.data) {
                //increment rank only if both sets have same rank
                parent2.parent = parent1;

            } else {
                parent1.parent = parent2;
            }
            return true;
        }

        /**
         * Finds the representative of this set
         */
        public int findSet(int data) {
            return findSet(map.get(data)).data;
        }

        /**
         * Find the representative recursively and does path
         * compression as well.
         */
        private Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node) {
                return parent;
            }
            node.parent = findSet(node.parent);
            return node.parent;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int querry = Integer.parseInt(s1[1]);

        Set<Integer> set = new HashSet<>();
        int[] given = new int[size];
        DisjointSet disjointSet = new DisjointSet();

        s1 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
            disjointSet.makeSet(given[i]);
            set.add(given[i]);
        }
        for(int i=size-1;i>=0;i--){
            if(set.contains(given[i]+1)){
                disjointSet.union(given[i],given[i]+1);
            }
            else{
                disjointSet.makeSet(given[i]+1);
                disjointSet.union(given[i],given[i]+1);
            }
        }
        for(int t=0;t<querry;t++){
            int a = Integer.parseInt(inp.readLine());

            if(set.contains(a+1)){
                int c = disjointSet.findSet(a+1);
                DisjointSet.Node node = disjointSet.getNode(c);
                System.out.println(node.parent.data);
            }
            else{
                System.out.println(a+1);
            }
        }
    }
}
