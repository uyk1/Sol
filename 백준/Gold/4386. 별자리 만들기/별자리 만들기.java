import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//별의 위치를 저장하는 클래스
	static class Star {
		double x;
		double y;
		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	//간선 정보를 저장하는 클래스
	static class  Edge implements Comparable<Edge>{
		int from;
		int to;
		double dist;
		
		public Edge(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		public int compareTo(Edge o) {
			return (int) (this.dist - o.dist);
		}
	}
	
	static int n;
	static Star[] Slist;//별 배열
	static int[] parent;//대표자 배열
	static Queue<Edge> pq = new PriorityQueue<>();
	static double ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //별(정점)의 개수(1~100)
		Slist = new Star[n+1];
		for(int i = 1; i <= n; i++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			Slist[i] = new Star(x, y);
		}
		//대표자 배열 초기화
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) parent[i] = i;
		//받은 별 배열을 이용해 간선 구하기(dist 계산)
		for(int i = 1; i < n; i++) {
			for(int j = i+1; j <= n; j++) {
				double d = calc(Slist[i], Slist[j]);//거리 계산
				pq.add(new Edge(i, j, d));//우선순위 큐에 간선 추가(이 과정에서 각 별 인덱스도 같이 표현됨)
			}
		}
		ans = 0;//거리비용 초기화
		//dist에 의한 우선순위 순대로 큐에서 뽑기
		int size = pq.size();
		for(int i = 0; i < size; i++) {
			Edge e = pq.poll();
			//두 별이 같은 대표자를 가졌는지를 확인하기 위해 탐색(동시에 대표자 수정)
			int f = find(e.from);
			int t = find(e.to);
			//아니라면 병합 및 비용 더하기 //여기서 확인하므로 chk메서드는 필요 없음
			if(f != t) {
				ans += e.dist;
				union(e.from, e.to);
			}
		}
		
		System.out.println(String.format("%.2f", ans));
	}//main
	
	static double calc(Star from, Star to) {
		//피타고라스 정리를 이용해 거리 계산
		//x좌표가 같을 때
		if(from.x == to.x) return Math.abs(from.y - to.y);
		//y 좌표가 같을 때
		if(from.y == to.y) return Math.abs(from.x - to.x);
		//둘 다 다를 때
		double res
			= Math.sqrt(Math.pow((from.x - to.x), 2) + Math.pow((from.y - to.y), 2));
		return res;
	}
	
	static int find(int x) {
		//대표자가 자기 자신이면 자신 반환
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		//유니온 과정에서 이 파인드 과정을 꼭 진행해주어야 함
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;
	}
}
