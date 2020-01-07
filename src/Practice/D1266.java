package Practice;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class D1266 {
    static class Data{
        int a;
        int b;
        long c;
        Data(int a,int b,long c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return (a+" "+b+" "+c);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int vertices = Integer.parseInt(s1[0]);
        int edges = Integer.parseInt(s1[1]);

        long[] values = new long[vertices+1];
        for(int i=0;i<edges;i++){
            s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            int c = Integer.parseInt(s1[2]);
            values[a] += -c;
            values[b] += c;
        }

        Queue<Integer> pos = new ArrayDeque<>();
        Queue<Integer> neg = new ArrayDeque<>();

        for(int i=1;i<=vertices;i++){
            if(values[i]>0){
                pos.add(i);
            }
            else if(values[i]<0){
                neg.add(i);
            }
        }

        ArrayList<Data> list = new ArrayList<>();

        while (pos.size()>0 && neg.size()>0){
//            System.out.println(pos);
//            System.out.println(neg);
            int p = pos.poll();
            int n = neg.poll();
            long sum = values[p]+values[n];

            if(sum>0){
                values[p] = sum;
                pos.add(p);
                list.add(new Data(n,p,Math.abs(values[n])));
            }
            if(sum<0){
                values[n] = sum;
                neg.add(n);
                list.add(new Data(n,p,Math.abs(values[p])));
            }
            if(sum==0){
                list.add(new Data(n,p,Math.abs(values[p])));
            }
        }


        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            Data data = list.get(i);
            out.write(data.a+" "+data.b+" "+data.c+"\n");
        }
        out.flush();

       // System.out.println(list);




    }
}
