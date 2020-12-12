 /**
 * Write a description of Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

 

public class Point {
    private int _x = 0;
    private int _y = 0;
    
    Point(int x, int y) {
        _x = x;
        _y = y;
    }
    
    int getX() {
        return _x;
    }
    
    void setX(int newX) {
        _x = newX;
    }
    
    void mutatePoint(Point p) {
        p.setX(100);
    }
    
    void printX() {
        System.out.println(_x);
    }
}
