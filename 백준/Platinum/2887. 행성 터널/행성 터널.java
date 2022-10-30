import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//메모리 초과.. 해결법은 큐 용량 절감
public class Main {
	static class Planet {
		int x;
		int y;
		int z;
		int idx;
		public Planet(int x, int y, int z, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.idx = idx;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	static int N;
	static int[] parent;
	static Planet[] Plist;
	static Queue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		Plist = new Planet[N];
		for(int i = 0; i < N; i++) {
			//대표자 초기화, 행성리스트 생성
			StringTokenizer st = new StringTokenizer(br.readLine());
			parent[i] = i;
			Plist[i] = new Planet(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
		}
		//비용 계산 후 간선 생성, 우선순위 큐에 삽입
		//하려고 했으나 메모리 관계로 노선 변경.
		//터널이 총 N-1개 건설이므로 x기준 오름차순 N-1개까지, 그리고 나머지 둘 도 마찬가지로 간선 저장하면 충분
		//이 경우 각 기준을 따라 인접한 경우만을 확인하기 때문에 그 이외를 볼 필요가 없음.
		//각 기준에 따라 행성리스트 정렬
		Arrays.sort(Plist, (p1, p2) -> p1.x - p2.x);//x를 기준으로 오름차순 정렬
		for(int i = 0; i < N-1; i++) {
			int c = Plist[i+1].x-Plist[i].x;
			pq.add(new Edge(Plist[i].idx, Plist[i+1].idx, c));
		}
		Arrays.sort(Plist, (p1, p2) -> p1.y - p2.y);//y를 기준으로 오름차순 정렬
		for(int i = 0; i < N-1; i++) {
			int c = Plist[i+1].y-Plist[i].y;
			pq.add(new Edge(Plist[i].idx, Plist[i+1].idx, c));
		}
		Arrays.sort(Plist, (p1, p2) -> p1.z - p2.z);//z를 기준으로 오름차순 정렬
		for(int i = 0; i < N-1; i++) {
			int c = Plist[i+1].z-Plist[i].z;
			pq.add(new Edge(Plist[i].idx, Plist[i+1].idx, c));
		}
		//중복은 어차피 우선순위 큐에 의해 해결될 것
		//크루스칼 방식을 이용해 연결
		int size = pq.size();
		int ans = 0;//답
		for(int i = 0; i < size; i++) {
			Edge e = pq.poll();
			//대표자 찾아서 비교
			int f = find(e.from);
			int t = find(e.to);
			//같지 않으면 합치기
			if(f != t) {
				ans += e.cost;
				parent[t] = f;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		//경로 압축
		parent[x] = find(parent[x]);
		return parent[x];
	}
}