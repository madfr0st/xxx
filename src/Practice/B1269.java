package Practice;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int modulo = Integer.parseInt(s1[1]);
        int[] given = new int[size];
        int[] match = new int[size];
        String[] s2 = inp.readLine().split(" ");
        String[] s3 = inp.readLine().split(" ");

        for(int i=0;i<size;i++){
            int a = Integer.parseInt(s2[i]);
            int b = Integer.parseInt(s3[i]);
            given[i] = a;
            match[i] = b;

        }
        Arrays.sort(given);
        Arrays.sort(match);

        Set<Integer> set = new HashSet<>();

        int count = 0;
        int ans = -1;

        for(int i=0;i<size;i++){
            int a = 0;
            int b = 0;
            for(int j=0;j<size;j++){
                a = given[(j+count)%size];
                b = match[j];
                if(a<b){
                    a+=modulo;
                }
                set.add(a-b);
                //System.out.println(a+" "+b);
                if(set.size()>1){
                    break;
                }
            }
            a = given[(count)%size];
            b = match[0];
            if(set.size()==1){
                if(a>b){
                    ans = b+modulo-a;
                }
                else{
                    ans = b-a;
                }
            }
            set.clear();
            count++;
        }

        System.out.println(ans);



    }
}
