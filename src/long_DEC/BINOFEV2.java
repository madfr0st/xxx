package long_DEC;

import java.io.*;

public class BINOFEV2 {
    static long mod = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] s1 = inp.readLine().split(" ");
            long power = Long.parseLong(s1[0]);
            long n = Long.parseLong(s1[1]);
            long r = Long.parseLong(s1[2]);
        }
    }
}
