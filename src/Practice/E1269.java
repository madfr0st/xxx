package Practice;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class E1269 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());

        int left = 0;
        int right = 0;

        String[] s1 = inp.readLine().split(" ");
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            int a = Integer.parseInt(s1[i]);
            map.put(a,i+1);
            if(a==1){
                left = i+1;
                right = i+1;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int count = 0;
        for(int i=1;i<size;i++){
            int index = map.get(i+1);
            if(index<left){
                left--;
                int a = Math.abs(map.get(i)-map.get(i+1))-1;
                count+=a+i;
                list.add(count);
            }
            else{
                right++;
                int a = Math.abs(map.get(i)-map.get(i+1))-1;
                count+=a;
                list.add(count);
            }

        }

        for(int i=0;i<size;i++){
            int a = list.get(i);
            out.write(a+" ");
        }
        out.flush();

        System.out.println(list);



    }
}
