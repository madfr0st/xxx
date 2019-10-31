package NeuralNetwork;

import java.util.stream.IntStream;

public class Neuron {
    private double[] weights = new double[]{0.0,0.0};
    private double threshold = 0.0;
    private double output = 0.0;
    private NeuralNetwork.LayerType layerType;

    public Neuron(NeuralNetwork.LayerType layerType){
        this.layerType = layerType;
    }
    public Neuron(double threshold,double[] weights,NeuralNetwork.LayerType layerType){
        this.threshold = threshold;
        this.weights = weights;
        this.layerType = layerType;
    }
    public Neuron adjust(){
        Neuron neuron = new Neuron(layerType);
        IntStream.range(0,weights.length).forEach(x -> neuron.weights[x] = weights[x] + Math.random() - 0.5);
        neuron.threshold = threshold + Math.random() - 0.5;
        return neuron;
    }
    public double applyActivationFunction(double weightedSum){
        output = 1.0/(1+Math.exp(-1.0*weightedSum));
        return output;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public NeuralNetwork.LayerType getLayerType() {
        return layerType;
    }

    public void setLayerType(NeuralNetwork.LayerType layerType) {
        this.layerType = layerType;
    }
}
