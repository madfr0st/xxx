package xxx;



import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Distinct {
    static Set<Integer> tree1[];
    static Set<Integer> tree2[];
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given1 = new int[size];
        int[] given2 = new int[size];
        int s = nextPowerOf2(size);
        s = 2*s-1;
        tree1 = new HashSet[s];
        tree2 = new HashSet[s];
        String[] s1 = inp.readLine().split(" ");
        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given1[i] = Integer.parseInt(s1[i]);
            given2[i] = Integer.parseInt(s2[i]);
        }
        for(int i=0;i<s;i++){
            tree1[i] = new HashSet<>();
            tree2[i] = new HashSet<>();
        }
        constructTree(given1,tree1,0,size-1,0);
        constructTree(given2,tree2,0,size-1,0);
        int querry = Integer.parseInt(inp.readLine());
        for(int i=0;i<querry;i++){
            String[] s4 = inp.readLine().split(" ");
            int a = Integer.parseInt(s4[0]);
            int b = Integer.parseInt(s4[1]);
            int c = Integer.parseInt(s4[2]);
            int d = Integer.parseInt(s4[3]);
            Set<Integer> set1 = rangeQuery(tree1,a-1,b-1,size);
            Set<Integer> set2 = rangeQuery(tree2,c-1,d-1,size);
            set1.addAll(set2);
            a = set1.size();
            System.out.println(set1);
            out.write(Integer.toString(a)+"\n");
        }
        out.flush();
    }
    static void constructTree(int[] given,Set<Integer> set[],int low,int high,int pos){
        if(low==high){
            //System.out.println(pos);
            set[pos].add(given[low]);
            return;
        }
        int mid = low+high;
        mid = mid/2;
        constructTree(given,set,low,mid,2*pos+1);
        constructTree(given,set,mid+1,high,2*pos+2);
        set[pos].addAll(set[2*pos+1]);
        set[pos].addAll(set[2*pos+2]);
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
    static Set<Integer> rangeQuery(Set<Integer> segmentTree[], int qlow, int qhigh, int len){
        return rangeQuery(segmentTree,0,len-1,qlow,qhigh,0);
    }
    private static Set<Integer> rangeQuery(Set<Integer> segmentTree[], int low, int high, int qlow, int qhigh, int pos){
        if(qlow <= low && qhigh >= high){
            return segmentTree[pos];
        }
        if(qlow > high || qhigh < low){
            Set<Integer> s = new HashSet<>();
            return s;
        }
        int mid = (low+high)/2;

        Set<Integer> r = rangeQuery(segmentTree,low,mid,qlow,qhigh,2*pos+1);
        r.addAll(rangeQuery(segmentTree,mid+1,high,qlow,qhigh,2*pos+2));
        return r;
    }

}