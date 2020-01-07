package Practice;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class C1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int delta = Integer.parseInt(s1[1]);

        int[] g = new int[size];
        int[] g1 = new int[size];
        int min = 0;


        Set<Integer> set = new HashSet<>();
        int[] given = new int[delta];
        String[] s2 = inp.readLine().split("");
        for(int i=0;i<size;i++){
            int a = Integer.parseInt(s2[i]);
            set.add(i);
            g[i] = a;
            min = Math.min(a,min);
            if(i<delta){
                given[i] = a;
                g1[i] = a;
            }
            else{
                g1[i] = g1[i-delta];
            }
        }

        for(int i=0;i<10;i++){
            set.add(i);
        }

        boolean perfect = true;
        for(int i=delta;i<size;i++){
            if(g1[i] > g[i]){
                perfect = true;
                break;
            }
            else if(g1[i]<g[i]){
                perfect = false;
                break;
            }
        }


            //out.write(perfect+"");

        if(!perfect) {

            boolean ans = false;
            int index = -1;
            int b = 0;
            for (int i = delta - 1; i >= 0; i--) {
                int a = given[i];
                b = a;
                b++;
                while (b <= 9) {
                    if (set.contains(b)) {
                        ans = true;
                        break;
                    } else {
                        b++;
                    }
                }

                if (ans) {
                    index = i;
                    break;
                }
            }

            int[] output = new int[size];
            //System.out.println(index);

            for (int i = 0; i < index; i++) {
                output[i] = given[i];
            }
            output[index] = b;

            for (int i = index + 1; i < delta; i++) {
                output[i] = min;
            }

            for (int i = delta; i < size; i++) {
                output[i] = output[i - delta];
            }

            out.write(size + "\n");
            for (int i = 0; i < size; i++) {
                out.write(output[i] + "");
            }
            out.flush();

        }
        else{
            out.write(size + "\n");
            for (int i = 0; i < size; i++) {
                out.write(g1[i] + "");
            }
            out.flush();
        }



    }
}
