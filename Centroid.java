package clustering;
import java.lang.*;
import java.util.*;

/*
 * Centroid class to define primitive Coordinate object
 */

public class Centroid {
 
  Double x;
  Double y;
  
  //Constructor
  public Centroid(Double x, Double y) {
    this.x = x;
    this.y = y;
  }
  
  //Method to generate random Centroid
  public static Centroid random(Double maxX, Double maxY) {
    Double random = new Random().nextDouble();
    Double x = 0.0 + (random * (maxX - 0.0));
    random = new Random().nextDouble();
    Double y = 0.0 + (random * (maxY - 0.0));
    return new Centroid(x, y);
  }
  
  //Method to produce String Centroid representation
  public String toString() {
    return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+")";
  }
  
  //Method to set X value of Centroid
  public void setX(Double x) {
    this.x = x;
  }
  
  //Method to get X value of Centroid
  public Double getX() {
    return this.x;
  }
  
  //Method to set Y value of Centroid
  public void setY(Double y) {
    this.y = y;
  }
  
  //Method to get Y value of Centroid
  public Double getY() {
    return this.y;
  }
  
  //Method to get Euclidean Distance between two Centroids
  public Double getDistance(Centroid o) {
    return Math.sqrt(Math.pow((this.getX()-o.getX()),2)+Math.pow((this.getY()-o.getY()),2));
  }

}