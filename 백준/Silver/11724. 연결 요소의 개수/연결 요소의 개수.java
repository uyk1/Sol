import java.util.Scanner;

public class Main {
	static int N, M, ans;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[1001][1001];
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		visited = new boolean[1001];
		ans = 0;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				ans++;
				dfs(i);//정점 방문
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		for(int i = 1; i <= N; i++) {
			//행(즉, 현재 정점)에서 이어진 점이 있고 아직 방문하지 않았다면 방문
	        if(map[v][i] == 1 && !visited[i]) dfs(i);
	    }
	}
}