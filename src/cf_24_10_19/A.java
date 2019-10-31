package cf_24_10_19;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1]);
        if(a+1==b){
            System.out.println(a+" "+b);
        }
        else if( a==b){
            System.out.println(a+"19"+" "+b+"20");
        }
        else if(a==9 && b==1){
            System.out.println(9+" "+10);
        }
        else {
            System.out.println(-1);
        }
    }
}
