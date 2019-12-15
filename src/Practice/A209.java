package Practice;

import java.io.*;

public class A209 {
    static int modulo = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        long dp0 = 0;
        long dp1 = 0;
        boolean one = true;

        for(int i=0;i<size;i++){

            if(one){
                dp1 = (dp1 + dp0 + 1) % modulo;
                one = false;
            }
            else{
                dp0 = (dp0 + dp1 + 1) % modulo;
                one = true;
            }

        }

        System.out.println((dp1+dp0)%modulo);

    }
}
