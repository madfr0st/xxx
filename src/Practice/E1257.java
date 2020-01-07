package Practice;

import java.io.*;

public class E1257 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] s1 = inp.readLine().split(" ");
        int a = Integer.parseInt(s1[0]);
        int b = Integer.parseInt(s1[1])+1+a;

        s1 = inp.readLine().split(" ");

        int A2 = 0;
        int A3 = 0;
        for(int i=0;i<s1.length;i++){
            int x = Integer.parseInt(s1[i]);
            if(x>a && x<b){
                A2++;
            }
            if(x>=b){
                A3++;
            }
        }

        s1 = inp.readLine().split(" ");

        int B1 = 0;
        int B3 = 0;
        for(int i=0;i<s1.length;i++){
            int x = Integer.parseInt(s1[i]);
            if( x<=a){
                B1++;
            }
            if(x>=b){
                B3++;
            }
        }

        s1 = inp.readLine().split(" ");

        int C1 = 0;
        int C2 = 0;
        for(int i=0;i<s1.length;i++){
            int x = Integer.parseInt(s1[i]);
            if(x<=a){
                C1++;
            }
            if(x>a && x<b){
                C2++;
            }
        }

        System.out.println(A2+" "+A3+" "+B1+" "+B3+" "+C1+" "+C2);

        int ans = 0;

        int x = 0;
        x = Math.min(A2,B1);
        ans+=x;
        A2-=x;
        B1-=x;

        x = Math.min(A3,C1);
        ans+=x;
        A3-=x;
        C1-=x;

        x = Math.min(C2,B3);
        ans+=x;
        C2-=x;
        B3-=x;

        int deltaA = A2+A3;
        int deltaB = B1+B3;
        int deltaC = C1+C2;

        ans+=deltaA+deltaC;

        System.out.println(ans);





    }
}
