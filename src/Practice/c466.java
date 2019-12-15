package Practice;

import java.io.*;

public class c466 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] given = new int[size];
        String[] s1 = inp.readLine().split(" ");
        long sum = 0;

        for(int i=0;i<size;i++){
            given[i] = Integer.parseInt(s1[i]);
            sum += given[i];
        }

        if(sum%3==0){

            sum /=3;
            int[] check = new int[size+1];
            int[] count = new int[size+1];
            long s = 0;
            int left = -1;
            for(int i=0;i<size-2;i++){
                s+=given[i];
                if(s==sum){
                    check[i]=0;
                    left = i;
                    break;
                }
            }

            if(left>=0) {
                s = 0;

                for (int i=left+1; i<size; i++) {
                    s+=given[i];
                    if(s==sum){
                        //System.out.println(i);
                        check[i] = 1;
                    }
                }

                count[size] = check[size];
                for(int i=size-1;i>=0;i--){

                    count[i] = count[i+1]+check[i];

                }

                int ans = 0;
                for(int i=0;i<size-2;i++){
                    if(check[i]==1){
                        System.out.println(i);
                        ans+=count[i+2];
                    }
                }
                System.out.println(ans);



            }



            else{
                System.out.println(0);
            }
        }
        else{
            System.out.println(0);
        }
    }
}
