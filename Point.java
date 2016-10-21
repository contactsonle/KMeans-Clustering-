package clustering;
import java.util.*;

/*
 *  Point class to define Point object, subclass of Centroid
 */

public class Point extends Centroid {
 
  Centroid mean;
  
  //Constructor
  public Point(Double x, Double y) {
    super(x, y);
    this.mean = null;
  }
  
  //Method to generate random Point object
  public static Point random(Double maxX, Double maxY) {
    Double random = new Random().nextDouble();
    Double x = 0.0 + (random * (maxX - 0.0));
    random = new Random().nextDouble();
    Double y = 0.0 + (random * (maxY - 0.0));
    return new Point(x, y);
  }
  
  //Method to produce String Point representation
  public String toString() {
    if (mean == null) {
      return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+") --> null";
    } else {
      return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+") --> "+mean.toString();
    }
  }

  //Method to set Mean of Point
  public void setMean(Centroid c) {
    this.mean = c;
  }
  
  //Method to get Mean of Point
  public Centroid getMean() {
    return this.mean;
  }
}