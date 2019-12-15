package Practice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B294 {

    static class Index {
        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }

    static public int topDownRecursive(int values[], int weights[], int W) {
        //map of key(remainingWeight, remainingCount) to minimumWidth they can get.
        Map<Index, Integer> map = new HashMap<>();
        return topDownRecursiveUtil(values, weights, W, values.length, 0, map);
    }

    static public int topDownRecursiveUtil(int width[], int thickness[], int remainingWidth, int totalItems, int currentItem, Map<Index, Integer> map) {
        //if currentItem exceeds total item count AND remainingWidth is less than 0 then
        //just return with remainingWidth and 0 resp;
        if(currentItem >= totalItems ) {
            return remainingWidth;
        }
        else if( remainingWidth <= 0) {
            return 0;
        }

        //fom a key based on remainingWidth and remainingCount
        Index key = new Index();
        key.remainingItems = totalItems - currentItem -1;
        key.remainingWeight = remainingWidth;

        //see if key exists in map. If so then return the minimumValue for key stored in map.
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int minValue;
        //if width of item is more than remainingWidth then try next item by skipping current item
        if(remainingWidth < width[currentItem]+thickness[currentItem]) {
            minValue = topDownRecursiveUtil(width, thickness, remainingWidth, totalItems, currentItem + 1, map);
        } else {
            //try to get minimumWidth of either by picking the currentItem or not picking currentItem
            minValue = Math.min(width[currentItem] + topDownRecursiveUtil(width, thickness, remainingWidth
                            - width[currentItem]-thickness[currentItem], totalItems, currentItem + 1, map),
                    topDownRecursiveUtil(width, thickness, remainingWidth, totalItems, currentItem + 1, map));
        }
        //memoize the key with minWidth found to avoid recalculation
        map.put(key, minValue);
        return minValue;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(inp.readLine());
        int[] thickness = new int[size];
        int[] width = new int[size];
        int sum = 0;

        for(int i=0;i<size;i++){
            String[] s1 = inp.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            thickness[i] = a;
            width[i] = b;
            sum += a;
        }

        int ans = topDownRecursive(width,thickness,sum);

        System.out.println(ans);



    }

}
