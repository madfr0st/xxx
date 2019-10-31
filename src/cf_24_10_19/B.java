    package cf_24_10_19;

    import java.io.*;
    import java.util.*;

    public class B {
        static class Pair<U extends Comparable<U>, V extends Comparable<U>>
                implements Comparable<Pair<U,V>>{

            public final U a;
            public final V b;

            private Pair(U a, V b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o)
                    return true;
                if (o == null || getClass() != o.getClass())
                    return false;

                Pair<?, ?> pair = (Pair<?, ?>) o;
                if (!a.equals(pair.a))
                    return false;
                return b.equals(pair.b);
            }

            @Override
            public int hashCode() {
                return 31 * a.hashCode() + b.hashCode();
            }

            @Override
            public String toString() {
                return "(" + a + ", " + b + ")";
            }

            @Override
            public int compareTo(Pair<U, V> o) {
                return getU().compareTo(o.getU());
            }
            private U getU() {
                return a;
            }
            private V getV() {
                return b;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int testCase = Integer.parseInt(inp.readLine());
            for(int t=0;t<testCase;t++){

                String[] s1 = inp.readLine().split(" ");
                int n = Integer.parseInt(s1[0]);
                int k = Integer.parseInt(s1[1]);
                int d = Integer.parseInt(s1[2]);

                int left = 0;
                int right = d;
                int[] given = new int[n];
                String[] s2 = inp.readLine().split(" ");
                for(int i=0;i<n;i++){
                    given[i] = Integer.parseInt(s2[i]);
                }
                Map<Integer,Integer> map = new HashMap<>();
                //System.out.println(map);
                Set<Integer> set = new HashSet<>();
                for (int i=0;i<d;i++){
                    if(!map.containsKey(given[i])){
                        map.put(given[i],1);
                        set.add(given[i]);
                    }
                    else{
                        int a = map.get(given[i]);
                        a++;
                        map.put(given[i],a);
                    }
                }

                int min  = set.size();
                //System.out.println(set);
                while (right<n){
                    if(!map.containsKey(given[right])){
                        map.put(given[right],1);
                        set.add(given[right]);
                    }
                    else{
                        int a = map.get(given[right]);
                        a++;
                        map.put(given[right],a);
                        if(a==1){
                            set.add(given[right]);
                        }
                    }
                    if(map.containsKey(given[left])){
                        int a = map.get(given[left]);
                        a--;
                        map.put(given[left],a);
                        if(a==0) {
                            set.remove(given[left]);
                        }
                    }
    //                System.out.println(set );
    //                System.out.println(map);
                    right++;
                    left++;
                    min = Math.min(set.size(),min);
                }
                out.write(min+"\n");

            }
            out.flush();
        }
    }
