package long_DEC;

import java.io.*;
import java.util.ArrayList;

public class BINOFEV {

    static long mod = 998244353;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++) {
            String[] s1 = inp.readLine().split(" ");
            long power = Long.parseLong(s1[0]);
            long n = Long.parseLong(s1[1]);
            long r = Long.parseLong(s1[2]);
            long start = System.currentTimeMillis();
            long ans = 0;
            long previous = 1;
            long denum = denum(n,r);
            for(int i=0;i<=power;i++){
                long pow = previous;
                if(pow>=r){
                    ans += ncr(pow,r);
                    ans %= mod;
                }
                previous = (n*previous)%mod;
            }
            ans *= denum;
            ans %= mod;
            out.write(ans+"\n");
            long stop = System.currentTimeMillis();
            double time = stop-start;
            time /= 1000;
            //System.out.println(time);

        }
        out.flush();
    }
    static long ncr(long n,long r){
        r = Math.min(n-r,r);
        long num = 1;

        for(int i=0;i<r;i++){
            num *= (n-i);
            num %= mod;
        }
        num %= mod;
        if(num<0){
            num += mod;
        }
        return num;
    }
    static long denum(long n,long r){
        r = Math.min(n-r,r);
        long denum = 1;

        for(int i=0;i<r;i++){
            denum *= (r-i);
            denum %= mod;
        }
        denum = inverseModulo(denum,mod);
        return denum;
    }
    static long power(long a,long b){
        ArrayList<Long> list = new ArrayList<>();
        long ans = a;
        if(b==0){
            return 1;
        }
        while (b>1){
            if(b%2==1){
                b = b/2;
                list.add(ans);
                ans*=ans;
                ans %= mod;
            }
            else{
                b = b/2;
                ans*=ans;
                ans %= mod;
            }
        }
        for(int i=0;i<list.size();i++){
            ans*=list.get(i);
            ans %= mod;
        }
        return ans;
    }

    static long inverseModulo(long a, long m)
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

}
