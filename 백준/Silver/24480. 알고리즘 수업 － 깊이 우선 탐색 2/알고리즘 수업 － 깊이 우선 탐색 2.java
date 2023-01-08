import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N, M, R;
	static List<Integer>[] edges;
	static int[] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) edges[i] = new ArrayList<Integer>();
		for(int i = 1; i <= M; i++) { //입력 받을 간선의 개수는 N 아니고 M
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		//내림차순 방문을 위해 edges 정렬
		for(int i = 1; i <= N; i++) Collections.sort(edges[i], Comparator.reverseOrder());;
		visited = new int[N+1];
		cnt = 1;
		
		dfs(R);
		
		for(int i = 1; i <= N; i++) System.out.println(visited[i]);
	}
	
	static void dfs(int r) {
		visited[r] = cnt;
		for(int i: edges[r]) {
			if(visited[i] == 0) {
				cnt++;
				dfs(i);
			}
		}
	}
}