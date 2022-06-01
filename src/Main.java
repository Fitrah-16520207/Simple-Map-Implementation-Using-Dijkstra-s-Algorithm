import java.util.*;
public class Main {
	public static void main(String[] args) {
		Vector<Point> vector[] = new Vector[10];
		vector[0] = new Vector<Point>();
		vector[0].add(new Point(8,1));
		vector[0].add(new Point(2,3));
		vector[0].add(new Point(11,4));
		vector[1] = new Vector<Point>();
		vector[1].add(new Point(8,0));
		vector[1].add(new Point(3,4));
		vector[1].add(new Point(10,3));
		vector[1].add(new Point(1,2));
		vector[2] = new Vector<Point>();
		vector[2].add(new Point(1,1));
		vector[2].add(new Point(3,3));
		vector[3] = new Vector<Point>();
		vector[3].add(new Point(2,0));
		vector[3].add(new Point(10,1));
		vector[3].add(new Point(3,2));
		vector[3].add(new Point(1,4));
		vector[4] = new Vector<Point>();
		vector[4].add(new Point(11,0));
		vector[4].add(new Point(3,1));
		vector[4].add(new Point(1,3));
		System.out.println("test");
		Djikstra.dijkstra(0,4,vector);
		
	}
}
