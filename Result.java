package clustering;

import static clustering.Cluster.fitness;
import static clustering.KMeans.KMeans;
import static clustering.KMeans2.KMeans2;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Result {
    public static void main(String[] arg) throws IOException{
        Cluster<Point> c = new Cluster<Point>();
        //Get points
        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                Point temp = new Point((double) i,(double) j);
                c.add(temp);
            }
        }
        Cluster<Point> result = KMeans2(c,20);
        System.out.println(fitness(result));
        
        //Print out this file for KMeans2
        String path = "C:\\";
        Path outfile = Paths.get(path+ "Points allocation using KMeans2.txt");
        ArrayList lines = new ArrayList<>();
        //add the line into the lines ArrayList preparing to write
        for (Object o : result){
            lines.add(o.toString());
    }       
        //Write to file:
        Files.write(outfile,lines, Charset.forName("UTF-8"));
        

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                Point temp = new Point((double) i,(double) j);
                c.add(temp);
            }
        }
        Cluster<Point> result_1 = KMeans(c,20);
        System.out.println(fitness(result_1));
        
       
        //Print out this file for KMeans
        Path outfile_1 = Paths.get(path+ "Points allocation using KMeans.txt");
        ArrayList lines_1 = new ArrayList<>();
        //add the line into the lines ArrayList preparing to write
        for (Object o_1 : result_1){
            lines_1.add(o_1.toString());
    }       
        //Write to file:
        Files.write(outfile_1,lines_1, Charset.forName("UTF-8"));
    }
}
