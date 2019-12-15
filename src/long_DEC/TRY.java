package long_DEC;

import java.io.IOException;

public class TRY {
    public static void main(String[] args)throws IOException {

        long start = System.currentTimeMillis();
        long ans = 0;
        for(int i=0;i<=1000000000;i++){
            ans++;
            ans *= ans;
        }
        System.out.println(ans);
        long stop = System.currentTimeMillis();
        double time = stop-start;
        time /= 1000;
        System.out.println(time);


    }
}
