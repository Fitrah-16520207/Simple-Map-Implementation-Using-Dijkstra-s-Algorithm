import java.util.*;


public class Djikstra {
	static final int Infinite = 999999999;
	public static void dijkstra(int start, int n,  Vector <Point> vector[]) {
		int dist[] = new int[10];
		int before[] = new int[10];
		PriorityQueue <Point> PQ = new PriorityQueue<Point>() ;
		Set <Integer> seen = new HashSet<Integer>();
		for (int x=0;x<dist.length;x++) {
			dist[x] = Infinite;
		}
		dist[start] = 0;
		before[start] = -1;
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
					before[next] = now.getV();
				}
			}
			x++;
			
		}
		System.out.print("Dari " + start + " ke " + n + " biaya: " + dist[n]+ " Simpul sebelumnya: "+ before[n] + "\n" );
		System.out.print("Jalur Simpul : ");
		Stack<Integer> jalur = new Stack<Integer>();
		int sebelum = n;
		jalur.push(n);
		while(before[sebelum] != -1) {
			jalur.push(before[sebelum]);
			sebelum = before[sebelum];	
		}
		while(!jalur.isEmpty()) {
			System.out.print(jalur.pop() );
			if(jalur.size()>0)System.out.print( " -> ");
		}
		System.out.println();
	}
}
