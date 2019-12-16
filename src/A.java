import java.io.*;
import java.util.*;


public class A {
    static int modulo = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(inp.readLine());
        int b = Integer.parseInt(inp.readLine());
        int c = Integer.parseInt(inp.readLine());
        int d = Integer.parseInt(inp.readLine());
        int c1 = Integer.parseInt(inp.readLine());
        int c2 = Integer.parseInt(inp.readLine());

        long ans = 0;

        if(c2>c1){

            int z = Math.min(Math.min(d,c),b);

            c = c-z;
            d = d-z;
            b = b-z;

            int x = Math.min(a,d);

            ans = z*c2+x*c1;

            System.out.println(ans);


        }
        else{

            int x = Math.min(a,d);
            a = a-x;
            d = d-x;
            int z = Math.min(Math.min(d,c),b);


            ans = z*c2+x*c1;

            System.out.println(ans);
        }



    }
}