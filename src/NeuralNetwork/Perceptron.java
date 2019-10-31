package NeuralNetwork;

public class Perceptron {

    public static final double learningRate = 0.05;
    static double[] initialWeights = {Math.random(),Math.random()};
    double calculateWeightedSum(int[] data,double[] weights){
        double weightedSum = 0;
        for(int i=0;i<data.length;i++){
            weightedSum += data[i]*weights[i];
        }
        return weightedSum;
    }
    int activationFunction(double weightedSum){
        if(weightedSum>1){
            return 1;
        }
        return 0;
    }
    public double[] adjustWeights(int[] data,double[] weights,double error){
        double[] adjustedWeights = new double[data.length];
        for(int i=0;i<data.length;i++){
            adjustedWeights[i] = learningRate*error*data[i]+weights[i];
        }
        return adjustedWeights;
    }
}
