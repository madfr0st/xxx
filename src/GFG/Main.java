package GFG;

import java.util.*;

class Pair<U extends Comparable<U>, V extends Comparable<V>>
        implements Comparable<Pair<U,V>>{

    public final U a;
    public final V b;

    public Pair(U a, V b) {
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



    // This Overriding used to compare two pairs on the basis of first element
    @Override
    public int compareTo(Pair<U, V> o) {
        return getU().compareTo(o.getU());
    }


    // This Overriding used to compare two pairs on the basis of Second element
    //    @Override
    //    public int compareTo(Pair<U, V> o) {
    //        return getV().compareTo(o.getV());
    //    }


    private U getU() {
        return a;
    }
    private V getV() {
        return b;
    }
}

public class Main {

    public static void main(String[] args){

        Pair<Integer,Integer> pair1 = new Pair<>(1,2);
        Pair<Integer,Integer> pair2 = new Pair<>(2,2);
        Pair<Integer,Integer> pair3 = new Pair<>(3,2);
        Pair<Integer,Integer> pair4 = new Pair<>(4,2);
        Pair<Integer,Integer> pair5 = new Pair<>(5,2);

        ArrayList<Pair<Integer,Integer>> list = new ArrayList<>();

        list.add(pair2);
        list.add(pair5);
        list.add(pair1);
        list.add(pair4);
        list.add(pair3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
