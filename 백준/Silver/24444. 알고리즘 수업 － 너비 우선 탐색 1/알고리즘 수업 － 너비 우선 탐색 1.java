import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		List<Integer>[] edges = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) edges[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edges[a].add(b);
			edges[b].add(a);
		}
		//오름차순 방문을 위한 정렬
		for(int i = 1; i <= N; i++) Collections.sort(edges[i]);
		int[] visited = new int[N+1]; //방문확인 및 순서 저장
		
		//BFS를 위한 큐 생성
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		int cnt = 1;
		visited[R] = cnt++;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i: edges[curr]) {
				if(visited[i] == 0) {
					visited[i] = cnt++;
					q.add(i);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) sb.append(visited[i] + "\n");
		System.out.println(sb);
	}
}