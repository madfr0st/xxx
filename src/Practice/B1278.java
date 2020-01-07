package Practice;

import java.io.*;

public class B1278 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++){
            String[] s1 = inp.readLine().split(" ");
            long a = Integer.parseInt(s1[0]);
            long b = Integer.parseInt(s1[1]);

            long diff = Math.abs(a-b);
            long sum = 0;
            int count = 0;
            long add = 1;

            while (sum+add<=diff){
                sum+=add;
                add++;
                count++;
            }

            diff-=sum;
            if(diff>0){
                count++;
            }

            sum = count*count+count;
            sum/=2;
            sum%=2;
            diff = Math.abs(a-b);
            diff%=2;
            if(sum!=diff){
                count++;
            }

            System.out.println(count);



        }


    }
}
