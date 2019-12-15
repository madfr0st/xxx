package Practice;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class MonkAndNewArray {
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);

        int min = Integer.MAX_VALUE;

        int[] given = new int[m];
        int[] next = new int[m];

        String[] s2 = inp.readLine().split(" ");
        for(int i=0;i<m;i++){
            given[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(given);

        for(int i=1;i<n;i++){

            next = new int[m];
            s2 = inp.readLine().split(" ");
            for(int ii=0;ii<m;ii++){
                next[ii] = Integer.parseInt(s2[ii]);
            }
            Arrays.sort(next);

            for(int j=0;j<m;j++){
                int a = given[j];
                int index = Arrays.binarySearch(next,a);
                if(index>=0){
                    min = 0;
                    //print(given);
                    //print(next);
                    //System.out.println(i+" "+a+" "+index);
                    break;
                }
                else{
                    index = -index-1;
                    int left = index-1;
                    int right = index;
                    if(left>=0){
                        min = Math.min(min,a-next[left]);
                    }
                    if(right<m){
                        min = Math.min(min,next[right]-a);
                    }
                }
            }

            if(min==0){
                break;
            }
            else{
                given = new int[m];
                given = next;
            }
        }
        System.out.println(min);


    }
    static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
