package Practice;

import java.io.*;

public class A1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        int a = 14;
        int b = 15;
        int c = 16;

        int given = Integer.parseInt(inp.readLine());

        a+=given;
        b+=given;
        c+=given;

        boolean ans = false;
        int x = -1;
        for(int i=0;i<3;i++) {
            int root = (int)Math.sqrt(a);
            int d = 0;
            if(i==0){
                d = a;
            }
            if(i==1){
                d = b;
            }
            if(i==2){
                d = c;
            }
            x=d;

            for(int j=2;j<=root;j++){
                if(d%j==0){
                    ans = true;
                    x-=given;
                    break;
                }
            }
            if(ans){
                break;
            }
        }

        if(x==14){
            System.out.println(a+" "+14);
        }
        if(x==15){
            System.out.println(b+" "+15);
        }
        if(x==16){
            System.out.println(c+" "+16);
        }



    }
}
