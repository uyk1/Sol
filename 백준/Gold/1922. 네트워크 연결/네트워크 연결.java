import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int from;
		int cost;
		public Node(int to, int from, int cost) {
			super();
			this.to = to;
			this.from = from;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	static int N, M, ans;
	static int[] parent;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점의 수
		M = sc.nextInt();//간선의 수
		parent = new int[N+1];//각 정점의 대표자 확인
		//우선순위 큐 설정
		Queue<Node> q = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			parent[i] = i;//초기화(자기 자신 대표)
		}
		//비용에 따른 우선순위 큐 삽입
		for(int i = 0; i < M; i++) {
			q.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		ans = 0;
		//입력 및 초기화 끝
		
		int size = q.size();
		for(int i = 0; i < size; i++) {
			Node node = q.poll();
			int to = node.to;
			int fr = node.from;
			//자기자신에게 다시 연결할 필요는 없음
			if(to != fr) {
				//두 정점의 대표자가 동일한지 확인
				//아니라면 합병(같은 대표자)
				if(!chk(to, fr)) {
					ans += node.cost;
					union(to, fr);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int find(int x) {
		//자기자신을 대표한다면 이 그룹의 대표자이므로
		if(parent[x] == x) return x;
		//탐색하면서 동시에 대표자를 수정
		return parent[x] = find(parent[x]);
	}
	
	static boolean chk(int x, int y) {
		int toP = find(x);
		int fromP = find(y);
		if(toP != fromP) return false;
		return true;
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
}