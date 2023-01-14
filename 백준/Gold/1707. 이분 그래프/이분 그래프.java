import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS 방식 풀이 //주의사항: 비연결 그래프도 고려해야함!
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		outer:
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점의 개수
			int E = Integer.parseInt(st.nextToken()); //간선의 개수
			List<Integer>[] edges = new ArrayList[V+1];
			for(int i = 1; i <= V; i++) edges[i] = new ArrayList<>(); //초기화
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a].add(b);
				edges[b].add(a);
			}
			int[] visited = new int[V+1];
			//정점들을 다른 숫자로 구분 -> 현재 방문지에 1의 값을 준다면 인접지에는 2의 값을 준다.
			//인접한 정점을 다른 색으로 칠한다고 생각하면 편함!
			//비연결 그래프일 경우를 확인하기 위해 반복문으로 돌리기
			for(int i = 1; i <= V; i++) {
				//아직 방문하지 않은 정점을 만나면 시작
				if(visited[i] == 0) {
					Queue<Integer> q = new LinkedList<>();
					q.add(i);
					visited[i] = 1;
					while(!q.isEmpty()) {
						int curr = q.poll();
						for(int j: edges[curr]) {
							//색이 일치하는 인접 정점을 만날 경우 이분 그래프가 아님
							if(visited[curr] == visited[j]) {
								sb.append("NO\n");
								continue outer;
							}
							if(visited[j] == 0) {
								if(visited[curr] == 1) visited[j] = 2;
								else visited[j] = 1;
								q.add(j);
							}
						}
					}
				}
			}
			//다 돌았다면 이분 그래프(두 개의 색으로 그래프 분리 가능)
			sb.append("YES\n");
		}
		System.out.println(sb);
	}
}