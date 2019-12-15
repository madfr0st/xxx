package long_DEC;

import java.io.*;

public class one {

    static long MI(long a, long m)
    {
        long m0 = m;
        long y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1)
        {
            // q is quotient
            long q = a / m;

            long t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0)
            x += m0;

        return x;
    }
    static long[] mod = new long[100001];
    static long[] modInverse = new long[100001];
    static int modulo = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        mod[0] = 1;
        modInverse[0] = MI(1,modulo);
        long calc = 1;


        for(int i=1;i<100001;i++){
            calc *= i;
            calc %=modulo;
            mod[i] = calc;
            modInverse[i] = MI(calc,modulo);
        }



        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {
            int size = Integer.parseInt(inp.readLine());
            String[] s1 = inp.readLine().split("");
            String[] s2 = inp.readLine().split("");
            int z1 = 0;
            int z2 = 0;
            for(int i=0;i<size;i++){
                if(s1[i].equals("0")){
                    z1++;
                }
                if(s2[i].equals("0")){
                    z2++;
                }
            }

            int o1 = size-z1;
            int o2 = size-z2;


            int min1 = size- Math.min(o1,o2) - Math.min(z1,z2);
            int max1 = Math.min(o1,z2) + Math.min(o2,z1);

            long ans = 0;
            for(int i=max1;i>=min1;i = i-2){
                ans += ((mod[size] * modInverse[i])%modulo) * modInverse[size-i];
                ans %=modulo;
            }
            System.out.println(ans);




        }
    }
}
