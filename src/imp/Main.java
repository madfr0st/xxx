package imp;

import java.io.*;

public class Main {
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
    static class Tri<X extends Comparable<X>,Y extends Comparable<Y>
            ,Z extends Comparable<Z>> implements Comparable<Tri<X,Y,Z>>{

        public final X a;
        public final Y b;
        public final Z c;

        private Tri(X a, Y b ,Z c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Tri<?, ?, ?> tri = (Tri<?, ?, ?>) o;
            if (!a.equals(tri.a))
                return false;
            if (!b.equals(tri.b))
                return false;
            return c.equals(tri.c);
        }

        @Override
        public int hashCode() {
            return 31 * a.hashCode() + b.hashCode() + c.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + " ,"+ c + ")";
        }

        @Override
        public int compareTo(Tri<X,Y,Z> o) {
            int x = getX().compareTo(o.getX());
            int y = getY().compareTo(o.getY());
            int z = getZ().compareTo(o.getZ());
            if(x==0){
                if(y==0){
                    return z;
                }
                return y;
            }
            return x;
        }
        private X getX() {
            return a;
        }
        private Y getY() {
            return b;
        }
        private Z getZ() {
            return c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
