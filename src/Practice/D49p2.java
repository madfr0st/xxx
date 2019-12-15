package Practice;

import java.io.*;

public class D49p2 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1  = inp.readLine().split("");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }
        int[] c1 = new int[size];
        int[] c2 = new int[size];

        for(int i=0;i<size;i++){
            if(i%2==1){
                c1[i] = 1;
                c2[i] = 0;
            }
            else{
                c1[i] = 0;
                c2[i] = 1;
            }
        }

        boolean[] delta1 = new boolean[size];
        boolean[] delta2 = new boolean[size];


        for(int i=0;i<size;i++){

            if(given[i]!=c1[i]){
                delta1[i] = true;
            }

            if(given[i]!=c2[i]){
                delta2[i] = true;
            }

        }


        int count1 = 0;
        int count2 = 0;

//        print(given);
//        print(c1);
//        print(c2);
//        print(delta1);
//        print(delta2);

        for(int i=0;i<size-1;i++){

            if(delta1[i]){
                count1++;
                delta1[i] = false;
            }

            if(delta2[i]){
                count2++;
                delta2[i] = false;
            }


        }

        if(delta1[size-1]){
            count1++;
        }
        if(delta2[size-1]){
            count2++;
        }

        System.out.println(Math.min(count1,count2));





    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void print(boolean[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
