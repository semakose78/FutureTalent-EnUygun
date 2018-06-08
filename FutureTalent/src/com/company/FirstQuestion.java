package com.company;

import com.sun.media.sound.InvalidDataException;
import javafx.scene.shape.TriangleMesh;

public class FirstQuestion {
    private Integer x[];
    private Integer y[];

    //This constructor initializes the triangle's corner values
    public FirstQuestion(Integer[] x, Integer[] y) throws InvalidDataException {
        if((x.length != 4) || (y.length != 4))
            throw new InvalidDataException();
        this.x = new Integer[x.length];
        this.y = new Integer[y.length];
        for (int i = 0; i <x.length ; i++) {
            this.x[i] = x[i];
            this.y[i] = y[i];
        }
    }

    //This method checks if the given point is in the triangle area
    //by using Fermat-Toricelli Point rule
    public boolean isInTheTriangle(){
        double[] distances = new double[3];
        double[] edgeLengths = new double[3];
        double pointDistanceSum = 0.0;
        double triangleEdgesLengthSum = 0.0;

        edgeLengths[0] = Math.sqrt(((x[0]-x[1])*(x[0]-x[1])) + (y[0]-y[1])*(y[0]-y[1]));
        edgeLengths[1] = Math.sqrt(((x[1]-x[2])*(x[1]-x[2])) + (y[1]-y[2])*(y[1]-y[2]));
        edgeLengths[2] = Math.sqrt(((x[0]-x[2])*(x[0]-x[2])) + (y[0]-y[2])*(y[0]-y[2]));

        //Calculate the distances between triangle corners as edge lenghts
        triangleEdgesLengthSum = edgeLengths[0] + edgeLengths[1] + edgeLengths[2];

        //Calculate the distance of the given point from each triangle corner
        for (int i = 0; i < x.length-1; i++) {
            distances[i] = Math.sqrt(((x[i]-x[3])*(x[i]-x[3])) + (y[i]-y[3])*(y[i]-y[3]));
            pointDistanceSum += distances[i];
        }

        //if the sum of the distances between given point and the corners is "smaller than the sum of the edges"
        //OR "bigger than half of the sum of the edges" return true, else return false.
        if((pointDistanceSum < triangleEdgesLengthSum) && (pointDistanceSum > (triangleEdgesLengthSum/2)))
            return true;
        return false;
    }
}
