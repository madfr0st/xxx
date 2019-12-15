package Practice;

import java.io.*;
import java.util.ArrayList;

public class B349 {
    static int rem;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        int[] given = new int[10];
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<9;i++){
            given[i+1] = Integer.parseInt(s1[i]);
            min = Math.min(given[i+1],min);
            if(min==given[i+1]){
                index = i+1;
            }
        }

        if(amount>=min) {
            rem = amount % min;

            int count = amount/min;
            ArrayList<Integer> list = new ArrayList<>();

            while (rem>0 && count>0) {
                int max = getMax(rem, given, min);
                out.write(max+"");
                count--;
            }
            for(int i=0;i<count;i++){
                out.write(index+"");
            }
            out.flush();


        }
        else{
            System.out.println(-1);
        }



    }
    static int getMax(int re,int[] given,int min){
        re += min;
        int max = 0;
        for(int i=1;i<10;i++){
            if(given[i]<=re){
                max = Math.max(i,max);
            }
        }
        rem = re-given[max];
        return max;
    }
}
