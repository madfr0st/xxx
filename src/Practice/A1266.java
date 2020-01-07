package Practice;

import java.io.*;

public class A1266 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++){
            String[] s1 = inp.readLine().split("");
            int sum = 0;
            int zero = 0;
            int even = 0;

            for(int i=0;i<s1.length;i++){
                int a = Integer.parseInt(s1[i]);
                sum+=a;
                if(a==0){
                    zero++;
                }
                else{
                    if(a%2==0){
                        even++;
                    }
                }
            }

            if(zero>0){
                if(zero>1){
                    if(sum%3==0){
                        out.write("red"+"\n");
                    }
                    else{
                        out.write("cyan"+"\n");
                    }
                }
                else{
                    if(even>0){
                        if(sum%3==0){
                            out.write("red"+"\n");
                        }
                        else{
                            out.write("cyan"+"\n");
                        }
                    }
                    else{
                        out.write("cyan"+"\n");
                    }
                }
            }
            else{
                out.write("cyan"+"\n");
            }



        }
        out.flush();


    }
}
