import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//Kruskal Algorithm
public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int from;
		int value;
		public Node(int to, int from, int value) {
			super();
			this.to = to;
			this.from = from;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
	
	static int V, E, ans;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		parent = new int[V+1]; //각 정점의 현재 대표자를 확보
		for(int i = 1; i < V+1; i++) parent[i] = i;
		//가중치를 기준으로 자동으로 뽑아내기 위해 우선순위 큐 설정
		Queue<Node> q = new PriorityQueue<>();
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt();//정점 1
			int b = sc.nextInt();//정점 2
			int c = sc.nextInt();//가중치
			q.add(new Node(a,b,c));
		}
		
		int size = q.size(); //간선의 수
		ans = 0;
		for(int i = 0; i < size; i++) {
			Node node = q.poll();
			//빼낸 간선의 두 정점이 같은 부모를 가지고 있는지 확인
			int to = find(node.to);
			int from = find(node.from);
			//동일 부모가 아니라면 합치기
			if(!chk(to, from)) {
				ans += node.value;
				union(node.to, node.from);
			}
		}
		System.out.println(ans);
	}
	//넘겨진 정점의 부모 정점을 확인하여 반환
	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	//병합
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;
	}
	//같은 부모를 가졌는지 확인
	static boolean chk(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		else return false;
	}
}