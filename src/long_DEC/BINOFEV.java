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
            long N = Long.parseLong(s1[0]);
            long n = Long.parseLong(s1[1]);
            long r = Long.parseLong(s1[2]);
            long ans = 0;
            long previous = 1;

            long denum = denum(n, r);
            if(r==2){
                if(n!=1) {
                    long a = power(n, 2);
                    long b = power(a, N);
                    b--;
                    b%=mod;
                    if(b<0){
                        b+=mod;
                    }
                    long c = modInverse(a - 1, mod);

                    long x = a * b;
                    x %= mod;
                    x *= c;
                    x %= mod;

                    a = n;
                    b = power(a, N);
                    b--;
                    b%=mod;
                    if(b<0){
                        b+=mod;
                    }
                    c = modInverse(a - 1, mod);
                    long y = a * b;
                    y %= mod;
                    y *= c;
                    y %= mod;
                    x = x - y;
                    if (x < 0) {
                        x += mod;
                    }
                    x %= mod;
                    x %= mod;
                    x *= denum;
                    x %= mod;

                    out.write(x + "\n");
                }
                else{
                    out.write(0+"\n");
                }

            }
            else {
                for (int i = 0; i <= N; i++) {
                    long pow = previous;
                    if (pow >= r) {
                        ans += ncr(pow, r);
                        ans %= mod;
                    }
                    previous = (n * previous) % mod;
                }
                ans *= denum;
                ans %= mod;
                out.write(ans + "\n");
            }

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
        denum = modInverse(denum,mod);
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
        if (ans<0){
            ans+=mod;
        }
        return ans;
    }
    static long modInverse(long a, long m)
    {
        long g = gcd(a, m);
        return power(a, m - 2, m);
    }

    // To compute x^y under modulo m
    static long power(long x, long y, long m)
    {
        if (y == 0)
            return 1;

        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }

    // Function to return gcd of a and b
    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
