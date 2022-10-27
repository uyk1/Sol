import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int to;//가는 방향
		int cost;//유지비
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	static int N, M, ans;
	static List<Node>[] list;
	static boolean[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점의 개수
		M = sc.nextInt();//간선의 개수
		list = new ArrayList[N+1];//정점 1번부터 N번까지
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();//초기화
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			//이와 같이 양방향을 다 리스트에 넣어주어야 함!
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		sel = new boolean[N+1];
		ans = 0;
		
		prim(1);
		
		System.out.println(ans);
	}
	
	static void prim(int v) {
		Queue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(v, 0));//시작 정점을 추가
		//마지막 하나의 간선의 유지비를 빼야하므로 아래와 같이 조건 설정
		int max = 0;
		while(!pq.isEmpty()) {
			Node nd = pq.poll();
			int next = nd.to;
			int cost = nd.cost;
			
			if(sel[next]) continue;
			//다음 예정지를 방문하지 않았다면 선택 정점에서 가장 낮은 가중치를 갖는 간선으로 이어진 정점 선택
			sel[next] = true;//방문처리
			ans += cost;
			max = Math.max(max, cost);
			//선택된 정점과 이어진 노드를 큐에 삽입(단, 그 노드의 다음 노드가 이미 방문한 정점이면 x. 
			for(Node node : list[next]) {
				if(!sel[node.to]) pq.add(node);
			}
		}
		//따라서
		ans -= max; 
	}
}