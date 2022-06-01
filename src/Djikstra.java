import java.util.*;


public class Djikstra {
	static final int Infinite = 999999999;
	public static void dijkstra(int start, int n,  Vector <Point> vector[]) {
		int dist[] = new int[10];
		PriorityQueue <Point> PQ = new PriorityQueue<Point>() ;
		Set <Integer> seen = new HashSet<Integer>();
		for (int x=0;x<dist.length;x++) {
			dist[x] = Infinite;
		}
		dist[start] = 0;
		PQ.add(new Point(0,start));
		System.out.println(PQ.size());
		int x=0;
		while (PQ.size()>0) {
			Point now = PQ.poll();
			if(seen.contains(now.getV()))continue;
			seen.add(now.getV());
			for(int i=0;i<vector[now.getV()].size();i++) {
				int next = vector[now.getV()].get(i).getV();
				int cost = vector[now.getV()].get(i).getDist();
				if(now.getDist() + cost < dist[next] || dist[next] == Infinite) {
					dist[next] = now.getDist() + cost;
					PQ.add(new Point(dist[next],next));
				}
			}
			x++;
			System.out.print("Iterasi ke " + x + "\n");
			
		}
		for (int i=0;i<n+1;i++) {
			System.out.print("from " + start + " to " + i + " : " + dist[i] + "\n" );
		}
	}
}
