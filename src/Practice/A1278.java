package Practice;

import java.io.*;
import java.util.Arrays;

public class A1278 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());

        for(int t=0;t<testCase;t++){
            int[] given = new int[26];
            String[] s1 = inp.readLine().split("");
            for(int i=0;i< s1.length;i++){
                int a = s1[i].charAt(0);
                a -= 97;
                given[a]++;
            }

            int size = s1.length;
            s1 = inp.readLine().split("");
            int[][] match = new int[s1.length][26];

            for(int i=0;i<s1.length;i++){
                if(i>0) {
                    match[i] = match[i - 1].clone();
                }
                int a = s1[i].charAt(0);
                a -= 97;
                match[i][a]++;
            }

//            for(int i=0;i<s1.length;i++){
//                print(match[i]);
//            }
//            System.out.println("---------");
//            print(given);

            boolean ans = false;

            for(int i=size-1;i<s1.length;i++){
                int[] check = new int[26];

                if(i>=size) {
                    for (int j = 0; j < 26; j++) {
                        check[j] = match[i][j] - match[i - size][j];
                    }
                }
                else{
                    check = match[i].clone();
                }
                //print(check);
                if(Arrays.equals(given,check)){
                    ans = true;
                    break;
                }

            }


            if(ans){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
