package clustering;
import java.util.*;

/*
 *  Cluster object defining List of Points/Centroids
 */

public class Cluster<T> extends ArrayList<T> {
  
  //Constructor
  public static Cluster<Point> random(Double maxX, Double maxY, Integer n) {
    Cluster<Point> c = new Cluster<Point>();
    for (int i = 0; i < n; i++) {
      c.add(Point.random(maxX, maxY));
    }
    return c;
  }
  
  //Method to display Cluster contents
  public void print() {
    for (Object o: this) {
      System.out.println(o.toString());
    }
  }
  
  //Method to determine equality between two Clusters
  public boolean equalsCluster(Cluster<T> other) {
    //Wrong size, not equal
    if (this.size() != other.size()) {
      return false;
    }
    //Check each entities
    for (int i = 0; i < this.size(); i++) {
      if (this.get(i) != other.get(i)) {
        return false;
      }
    }
    return true;
  }
  
  //Method to get maximum X coordinate within Cluster
  public Double getMaxX() {
    if (this.size() == 0) {
      return null;
    }
    Double maxX = ((Centroid) this.get(0)).getX();
    //Iterate and record down the maximum value
    for (Object o: this) {
      Centroid p = (Centroid) o;
      if (p.getX() > maxX) {
        maxX = p.getX();
      }
    }
    return maxX;
  }
  
  //Method to get maximum Y coordinate within Cluster
  public Double getMaxY() {
    if (this.size() == 0) {
      return null;
    }
    Double maxY = ((Centroid) this.get(0)).getY();
    //Iterate and record down the maximum value
    for (Object o: this) {
      Centroid p = (Centroid) o;
      if (p.getY() > maxY) {
        maxY = p.getY();
      }
    }
    return maxY;
  }
  
  //Method to get Centroid of Cluster
  public static Point getCentroid(Cluster<Point> c) {
    Double sumX = 0.0;
    Double sumY = 0.0;
    for (Point p: c) {
      sumX += p.getX();
      sumY += p.getY();
    }
    return new Point(sumX/c.size(), sumY/c.size());
  }
  
  //Method to get Means of Cluster
  public static Cluster<Centroid> getMeans(Cluster<Point> c) {
    Cluster<Centroid> means = new Cluster<Centroid>();
    //Iterate over the points to get the assigned mean of each
    for (Point p: c) {
      if (!means.contains(p.getMean())) {
        means.add(p.getMean());
      }
    }
    return means;
  }
  
  //Method to verify Means of Cluster
  public static boolean fitness(Cluster<Point> c) {
    if (c == null || c.size() == 0) {
      return true;
    }
    //Get the means
    Cluster<Centroid> means = Cluster.getMeans(c);
    for (Point p: c) {
      if (p.getMean() == null) {
        return false;
      }
      //Get bestMean and best Distance
      Centroid bestMean = means.get(0);
      Double bestDistance = p.getDistance(bestMean);
      for (Centroid m: means) {
        Double distance = p.getDistance(m);
        if (distance < bestDistance) {
          bestMean = m;
          bestDistance = distance;
        }
      }
      if (bestMean != p.getMean()) {
        return false;
      }
    }
    return true;
  }
  
}