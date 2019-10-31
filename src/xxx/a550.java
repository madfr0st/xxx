package xxx;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class a550 {
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] given = inp.readLine().split("");
        ArrayList<Integer> ab = new ArrayList<>();
        ArrayList<Integer> ba = new ArrayList<>();
        for (int i = 1; i < given.length; i++) {
            if (given[i].equals("A")) {
                if (given[i - 1].equals("B")) {
                    ba.add(i);
                }
            }
            if (given[i].equals("B")) {
                if (given[i - 1].equals("A")) {
                    ab.add(i);
                }
            }
        }
        if(ab.size()>1){
            if(ba.size()>1){
                System.out.println("YES");
            }
            else if(ba.size()==1){
                Iterator<Integer> iterator = ab.listIterator();
                boolean ans = false;
                while (iterator.hasNext()){
                    if(Math.abs(iterator.next()-ba.get(0))>1){
                        System.out.println("YES");
                        ans = true;
                        break;
                    }
                }
                if(!ans){
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("NO");
            }
        }
        else if(ba.size()>1){
            if(ab.size()==1){
                Iterator<Integer> iterator = ba.listIterator();
                boolean ans = false;
                while (iterator.hasNext()){
                    if(Math.abs(iterator.next()-ab.get(0))>1){
                        System.out.println("YES");
                        ans = true;
                        break;
                    }
                }
                if(!ans){
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("NO");
            }
        }
        else if(ab.size()==1 && ba.size()==1){
            if(Math.abs(ab.get(0)-ba.get(0))>1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        else{
            System.out.println("NO");
        }

    }
    static void print(boolean[] booleans){
        for(int i=0;i<booleans.length;i++){
            System.out.print(booleans[i]+" ");
        }
        System.out.println();
    }
}
