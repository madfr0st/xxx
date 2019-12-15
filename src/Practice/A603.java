package Practice;

import java.io.*;

public class A603 {
    public static void main(String[] args)throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split("");
        int[] given = new int[size];
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }

        int count0 = 0;
        int count1 = 0;
        boolean last0 = false;
        boolean last1 = false;

        boolean tri0 = false;
        boolean tri1 = false;


        for(int i=0;i<size;i++){

            int a = given[i];

            if(a==0){

                if(!last0){
                    count0++;
                    last0 = true;
                }

                if(last1){
                    count1++;
                    last1 = false;
                }

            }else{
                if(last0){
                    count0++;
                    last0 = false;
                }

                if(!last1){
                    count1++;
                    last1 = true;
                }
            }


        }


        System.out.println( Math.min(Math.max(count0,count1)+2,size));



    }
}
