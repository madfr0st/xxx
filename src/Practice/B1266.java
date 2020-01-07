package Practice;

import java.io.*;

public class B1266 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split(" ");
        for (int t = 0; t < testCase; t++) {
            long a = Long.parseLong(s1[t]);
            long c = a%14;
            long x = a/14;
            if(c>0 && x>0) {
                if (c < 7) {
                    out.write("YES" + "\n");
                } else {
                    out.write("NO" + "\n");
                }
            }
            else{
                out.write("NO"+"\n");
            }
        }
        out.flush();
    }
}
