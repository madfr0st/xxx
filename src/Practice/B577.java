package Practice;

import java.io.*;
import java.util.ArrayList;

public class B577 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int div = Integer.parseInt(s1[1]);

        boolean[] dp = new boolean[div];
        int[] given = new int[size];
        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s2[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        boolean ans = false;


        for(int i=0;i<size;i++){

            int a = given[i];
            a %= div;
            if(!dp[a]){
                dp[a] = true;
                list.add(a);


                int k = list.size()-1;

                for(int j=0;j<k;j++){
                    int b = (a+list.get(j))%div;
                    if(!dp[b]){
                        dp[b] = true;
                        list.add(b);
                    }
                }
                if(dp[0]) {
                    ans = true;
                    break;
                }

            }
            else{
                int k = list.size();

                for(int j=0;j<k;j++){
                    int b = (a+list.get(j))%div;
                    if(!dp[b]){
                        dp[b] = true;
                        list.add(b);
                    }
                }
                if(dp[0]){
                    ans = true;
                    break;
                }
            }
        }

        if(ans){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    static void print(boolean[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
