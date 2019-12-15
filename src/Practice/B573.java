package Practice;

import java.io.*;

public class B573 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }

        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = 1;
        right[size-1] = 1;

        for(int i=1;i<size;i++){
            if(left[i-1]<given[i]){
                left[i] = left[i-1]+1;
            }
            else if(left[i-1]==given[i]){
                left[i] = left[i-1];
            }
            else{
                left[i] = given[i];
            }
        }

        for(int i=size-2;i>=0;i--){
            if(right[i+1]<given[i]){
                right[i] = right[i+1]+1;
            }
            else if(right[i+1]==given[i]){
                right[i] = right[i+1];
            }
            else{
                right[i] = given[i];
            }
        }

        int[] ans = new int[size];
        int max = 0;
        for(int i=0;i<size;i++){
            ans[i] = Math.min(left[i],right[i]);
            max = Math.max(max,ans[i]);
        }
        System.out.println(max);
        //print(ans);
    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
