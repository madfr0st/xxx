import java.io.*;
import java.util.*;


public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(inp.readLine());
        String[] s1 = inp.readLine().split("");
        int[] given = new int[size];
        ArrayList<Integer> white = new ArrayList<>();

        int w = 0;
        int b = 0;

        for(int i=0;i<size;i++){
            if(s1[i].equals("W")){
                given[i] = 0;
                w++;
            }
            else{
                given[i] = 1;
                b++;
            }
        }

        if(size%2==0 && w%2==1 ) {
            System.out.println(-1);
        }
        else {

            int ans  = 0;
            ArrayList<Integer> list = new ArrayList<>();

            if (w % 2 == 1) {

                list = new ArrayList<>();
                for (int i = 0; i < size-1; i++) {
                    if (given[i] == 1) {
                        if (given[i + 1] == 1) {
                            list.add(i+1);
                            given[i] = 0;
                            given[i + 1] = 0;
                            ans++;
                        } else {
                            given[i] = 0;
                            given[i+1] = 1;
                            ans++;
                            list.add(i+1);
                        }
                    }
                }


            } else {
                list = new ArrayList<>();
                for (int i = 0; i < size-1; i++) {
                    if (given[i] == 0) {
                        if (given[i + 1] == 0) {
                            list.add(i+1);
                            given[i] = 1;
                            given[i + 1] = 1;
                            ans++;
                        } else {
                            given[i] = 1;
                            given[i+1] = 0;
                            ans++;
                            list.add(i+1);
                        }
                    }
                }
            }

            out.write(ans+"\n");
            for(int i=0;i<list.size();i++){
                out.write(list.get(i)+" ");
            }
            out.flush();
//            System.out.println(ans);
//            System.out.println(list);
        }

    }
}
