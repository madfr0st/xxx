package xxx;



import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Distinct {
    static int[] tree1;
    static int[] tree2;
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given1 = new int[size];
        int[] given2 = new int[size];
        int s = nextPowerOf2(size);
        s = 2*s-1;
        tree1 = new int[s];
        tree2 = new int[s];
        String[] s1 = inp.readLine().split(" ");
        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given1[i] = Integer.parseInt(s1[i]);
            given2[i] = Integer.parseInt(s2[i]);
        }
        constructTree(given1,tree1,0,size-1,0);
        constructTree(given2,tree2,0,size-1,0);
        for(int i=0;i<s;i++){
            System.out.println(tree1[i]);
        }
        int querry = Integer.parseInt(inp.readLine());
        for(int i=0;i<querry;i++){
            String[] s4 = inp.readLine().split(" ");
            int a = Integer.parseInt(s4[0]);
            int b = Integer.parseInt(s4[1]);
            int c = Integer.parseInt(s4[2]);
            int d = Integer.parseInt(s4[3]);
            a = rangeQuery(tree1,a-1,b-1,size) | rangeQuery(tree2,c-1,d-1,size);
            out.write(Integer.toString(a)+"\n");
        }

        out.flush();
    }
    static void constructTree(int[] given,int[] tree,int low,int high,int pos){
        if(low==high){
            tree[pos] = given[low];
            return;
        }
        int mid = low+high;
        mid = mid/2;
        constructTree(given,tree,low,mid,2*pos+1);
        constructTree(given,tree,mid+1,high,2*pos+2);
        tree[pos] = tree[2*pos+1] | tree[2*pos+2];
    }
    static int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
    static int rangeQuery(int[] segmentTree, int qlow, int qhigh, int len){
        return rangeQuery(segmentTree,0,len-1,qlow,qhigh,0);
    }
    private static int rangeQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            return 0;
        }
        int mid = (low+high)/2;
        return rangeQuery(segmentTree,low,mid,qlow,qhigh,2*pos+1)|rangeQuery(segmentTree,mid+1,high,qlow,qhigh,2*pos+2);
    }

}