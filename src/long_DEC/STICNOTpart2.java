package long_DEC;

import java.io.*;
import java.util.*;

public class STICNOTpart2 {

    static ArrayList<Integer> edgesValue;
    static ArrayList<Integer> verticesValue;
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(inp.readLine());
        for(int t=0;t<testCase;t++) {
            edgesValue = new ArrayList<>();
            verticesValue = new ArrayList<>();
            int vertices = Integer.parseInt(inp.readLine());

            for (int i = 0; i < vertices-1; i++) {
                String[] s1 = inp.readLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                int c = Integer.parseInt(s1[2]);
                edgesValue.add(c);
            }

            String[] s1 = inp.readLine().split(" ");
            //System.out.println(t);
            for(int i=0;i<vertices;i++){
                verticesValue.add(Integer.parseInt(s1[i]));
            }

            Collections.sort(edgesValue);
            Collections.sort(verticesValue);

            int count = 0;
            boolean check = false;
            int ans = 0;

            for(int i=0;i<vertices-1;i++){
                int a = edgesValue.get(i);
                while (count<vertices){
                    if(verticesValue.get(count)>=a){
                        ans++;
                        count++;
                        break;
                    }
                    else{
                        count++;
                    }
                }
                if(count==vertices){
                    check = true;
                    break;

                }
            }

            if(!check){
                if(verticesValue.get(vertices-1)>=edgesValue.get(vertices-2)){
                    ans++;
                }
            }
            out.write((vertices-ans)+"\n");
        }
        out.flush();
    }
}
