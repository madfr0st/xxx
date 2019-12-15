package Practice;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class B407 {
    static int modulo = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];

        String[] s1 = inp.readLine().split(" ");
        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
        }

        long[] moves = new long[size];

        Set<Integer> odd = new HashSet<>();
        Set<Integer> done = new HashSet<>();

        int at = 1;
        int last = -1;
        long count = 0;

        while (at<=size){
            if(done.contains(at)){
                count += moves[last-1]-moves[at-1]+1;
                //System.out.println(Math.abs(moves[last-1]-moves[at-1])+1);
                //print(moves);
                count %= modulo;
                at = last;
                done.add(last);
                odd.remove(last);
                at++;
            }
            else{
                if(odd.contains(at)){
                    odd.remove(at);
                    done.add(at);
                   // moves[at-1] = count%modulo;
                    last = at;
                    at++;
                    count++;
                }
                else{
                    odd.add(at);
                    last = at;
                    moves[at-1] = count%modulo;
                    at = given[at-1];
                    count++;
                    count %= modulo;
                }
            }
            moves[0] = 0;
            //System.out.println(at+" "+count);
        }

        count = count%modulo;
        if(count<0){
            count +=modulo;
        }
        System.out.println(count%modulo);
        //print(moves);



    }
    static void print(long[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
