
public class Point implements Comparable<Point> {
	private int V,dist;
	public Point(int dist,int V) {
		this.dist = dist;
		this.V = V;
	}
	public int getV() { return V; }
	public int getDist() {return dist;}
	public int compareTo (Point P) {
		if(this.dist > P.dist) return 1;
		else if(this.dist<P.dist) return -1;
		else return 0;
	}
}
