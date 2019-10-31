package NeuralNetwork;

public class Main {
    public static final double[][][]  TRAINGING_DATA = {{{0,0},{0}},{{0,1},{1}},{{1,0},{1}},{{1,1},{0}}};
    public static void main(String[] args){
        int[] check = new int[]{0,1,2,3};
        int k = 0;
        System.out.println(check[k++]+" "+k);
    }
    void printHeading(int loop){
        System.out.println("----------------------------------"+loop+"--------------------------------------------------");
        System.out.println(" w1 | w2 | x1 | x2 | Target result | Result | error | weightedSum | adjusted w1 | adjusted w2");
        System.out.println("--------------------------------------------------------------------------------------------");
    }
    void printData(int[][] data,double[] weights, int result, double error,double weightedSum, double[] adjustedWeights){
        System.out.println(String.format("%.2f",weights[0])+"|"+String.format("%.2f",weights[1])+"| "+data[0][0]+"  |  "+data[0][1]+" |       "
                +data[1][0]+"       |    "+  result+"   |  "
                + error+"  |    "+String.format("%.2f",weightedSum)+"     |     "+ String.format("%.2f",adjustedWeights[0])+"    |    "+String.format("%.2f",adjustedWeights[1]));
    }
}
