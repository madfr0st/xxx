package xxx;

import java.io.*;

public class c676 {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = inp.readLine().split(" ");
        int size = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);

        String[] given = inp.readLine().split("");
        int left=0;
        int right = 0;
        int a = 0;
        int b = 0;

        int max  = 0;

        while (right<size){
            if(b<=k){
                if(given[right].equals("a")){
                    a++;
                }
                else{
                    b++;
                    if (b>k){
                        if(given[left].equals("a")){
                            a--;
                        }
                        else{
                            b--;
                        }
                        left++;
                    }
                }
                right++;
                if(b<=k) {
                    max = Math.max(max, a + b);
                }
            }
            else{
                if(given[left].equals("a")){
                    a--;
                }
                else{
                    b--;
                }
                left++;
            }
            //System.out.println(left+" "+right);
        }
        a=0;
        b=0;
        left = 0;
        right = 0;
        while (right<size){
            if(a<=k){
                if(given[right].equals("b")){
                    b++;
                }
                else{
                    a++;
                    if (a>k){
                        if(given[left].equals("b")){
                            b--;
                        }
                        else{
                            a--;
                        }
                        left++;
                    }
                }
                right++;
                if(a<=k) {
                    max = Math.max(max, a + b);
                }
            }
            else{
                if(given[left].equals("b")){
                    b--;
                }
                else{
                    a--;
                }
                left++;
            }
           // System.out.println(left+" "+right);
        }
        System.out.println(max);

    }
}
