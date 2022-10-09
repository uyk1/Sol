import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static int[][] map;
	static boolean[] visited; //DFS
	static Queue<Integer> q = new LinkedList<Integer>(); //BFS
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //정점 수
		M = sc.nextInt(); //간선 수
		V = sc.nextInt(); //출발 노드
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		//간선 수만큼 반복해서 맵 채우기
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			map[s][e]++;
			map[e][s]++;
		} //노드 연결 맵
		//들어오는 정점 번호를 그대로 받아주기 위해 +1
		
		dfs(V); //현재 노드
		sb.append("\n");
		
		visited = new boolean[N+1]; //방문 기록 초기화
		bfs(V);
		
		System.out.println(sb);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		//v부터 시작해 모든 정점을 방문할 때까지 반복
		for(int i = 0; i <= N; i++)
			if(map[v][i] != 0 && !visited[i])
				dfs(i);
	}
	
	static void bfs(int v) {
		q.add(v); //큐를 활용한 BFS
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v + " ");
			//이미 시작 노드를 큐에 넣고 시작하므로 반복도 1부터 돌린다
			for(int i = 1; i <= N; i++) {
				if(map[v][i] != 0 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}