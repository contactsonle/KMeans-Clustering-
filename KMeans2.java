package clustering;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class KMeans2 {
  
  /*
   *  KMeans2 *twist* algorithm implementation
   */
  
  public static Cluster<Point> KMeans2(Cluster<Point> c, Integer k) throws IOException {
    if (c == null || c.size() == 0) {
      return c;
    }
    Cluster<Centroid> means = new Cluster<Centroid>();
    Double maxX = c.getMaxX();
    Double maxY = c.getMaxY();
    //Initially, choose random means from bounds of points
    for (int i = 0; i < k; i++) {
      means.add(Centroid.random(maxX, maxY));
    }
    boolean done = false;
    //Iteratively, until solution converges with no changes:
    while (!done) {
      done = true;
      //Go through each mean and find the nearest points
      for (Centroid m: means) {
        for (Point p: c) {
          if (p.getMean() == null) {
            p.setMean(m);
          } else if (p.getDistance(m) < p.getDistance(p.getMean())) {
            p.setMean(m);
          }
        }
      }
      //Compute the centroid of each cluster to update each mean
      for (Centroid m: means) {
        Integer count = 0;
        Double xTotal = 0.0;
        Double yTotal = 0.0;
        for (Point p: c) {
          if (p.getMean() == m) {
            count  += 1;
            xTotal += p.getX();
            yTotal += p.getY();
          }
        }
        if (count > 0) {
          if (m.getX() != xTotal/count) {
            m.setX(xTotal/count);
            done = false;
          }
          if (m.getY() != yTotal/count) {
            m.setY(yTotal/count);
            done = false;
          }
        }
      }
      if (done) {
        break;
      }
    }
    
    //Print out the final clusters to file
    String path = "C:\\Users\\conta\\Desktop\\";
    Path outfile = Paths.get(path+"Clusters using KMeans2.txt");
    ArrayList lines = new ArrayList<>();
    //add the line into the lines ArrayList preparing to write
    means.stream().forEach((o) -> {
        lines.add(o.toString());
    });       
    
    //Write to file
    Files.write(outfile,lines, Charset.forName("UTF-8"));
    //Print final state of KMeans2
    System.out.println(" Point:          Centroid:");
    c.print();
    return c;
  }
  
}
