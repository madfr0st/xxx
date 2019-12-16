import java.io.*;
import java.util.*;


public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int x = Integer.parseInt(s1[1]);
        int y = Integer.parseInt(s1[2]);

        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        int ur = 0;
        int ul = 0;
        int dr = 0;
        int dl = 0;

        for(int i=0;i<size;i++){
            s1 = inp.readLine().split(" ");
            int a =Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            if(a>x && b>y){
                ur++;
            }
            if(a>x && b<y){
                dr++;
            }
            if(a<x && b>y){
                ul++;
            }
            if(a<x && b<y){
                dl++;
            }

            if(b==y){
                if(a>x){
                    r++;
                }
                if(a<x) {
                    l++;
                }
            }
            if(x==a) {
                if(b>y){
                    u++;
                }
                if(b<y){
                    d++;
                }
            }


        }

        //System.out.println(u + " " + l + " "+ d + " "+ r);

        d += dl + dr;
        u += ur + ul;
        l += ul + dl;
        r += ur + dr;

        //System.out.println(ur + " " + ul + " "+ dr + " "+ dl);


        int m = Math.max(Math.max(Math.max(l,r),u),d);
        if(m==l){
            System.out.println(l);
            x = x-1;
            System.out.println(x+" "+y);
        }
        else if(m==r){
            System.out.println(r);
            x = x+1;
            System.out.println(x+" "+y);

        }
        else if(m==u){
            System.out.println(u);
            y = y+1;
            System.out.println(x+" "+y);

        }
        else{
            System.out.println(d);
            y = y-1;
            System.out.println(x+" "+y);

        }



    }
}

