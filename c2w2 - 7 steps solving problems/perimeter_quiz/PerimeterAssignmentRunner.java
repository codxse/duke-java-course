import edu.duke.*;
import java.io.File;
import java.lang.Math;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int nPoints = 0;
        for (Point p: s.getPoints()) {
            nPoints += 1;
        }
        return nPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        int largest = 0;
        double longestDistance = 0;
        Point lastPoint = s.getLastPoint();
        for (Point p: s.getPoints()) {
            double distance = lastPoint.distance(p);
            if (distance > longestDistance) {
                longestDistance = distance;
                largest = p.getY();
            }
            lastPoint = p;
        }
        return longestDistance;
    }

    public double getLargestX(Shape s) {
        // Put code here
        int largest = 0;
        for (Point p: s.getPoints()) {
            if (Math.abs(p.getX()) > largest) {
                largest = Math.abs(p.getX());
            }
        }
        return largest;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largest = 0.0;
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s);
            if (perim > largest) {
                largest = perim;
            }
                
        }
        return largest;
    }
    
    public String getCollsSize() {
        DirectoryResource dr = new DirectoryResource();
        double largest = 0.0;
        String colls = "";
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s);
            if (perim > largest) {
                largest = getPerimeter(s);
            }
        colls = colls + "___" + perim;
        }
        return colls;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largest = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perim = getPerimeter(s);
            if (perim > largest) {
                largest = perim;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double avg = getAverageLength(s);
        System.out.println("avg = " + avg);
        double largestY = getLargestSide(s);
        System.out.println("largest side = " + largestY);
        double largestX = getLargestX(s);
        System.out.println("largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestMult = getLargestPerimeterMultipleFiles();
        System.out.println(getCollsSize());
        System.out.println("largest multiple = " + largestMult);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter();
        System.out.println("largest file name = " + name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println("file name = " + f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
