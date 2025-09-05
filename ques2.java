//Use record in Java 17 to create immutable Point(x,y) and calculate distance between two points.

public class ques2{
    public record Point(double x,double y){
        public double distance(Point other){
            double dx=this.x - other.x;
            double dy=this.y-other.y;
            return Math.sqrt(dx*dx+dy*dy);
        }
    }
    public static void main(String args[]){
        Point p1=new Point(10,5);
        Point p2=new Point(5,3);
        double res = p1.distance(p2);
        System.out.println(res);
    }
}