import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	//연결된 집을 찾기 위한 델타 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static ArrayList<Integer> list = new ArrayList<>();
	static int hcnt;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					hcnt = 1; //단지 내 집 카운트 초기화
					bfs(i, j); //현재 좌표
					list.add(hcnt);
				}
			}
		}
		Collections.sort(list); //오름차순 정렬
		System.out.println(list.size());
		for(int i : list) System.out.println(i);
	}//main
	
	static void bfs(int x, int y) {
		//여기서 큐에 넣을 것은 좌표이므로 2차원 LinkedList 활용
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y}); //탐색 시작 좌표
		
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = cx + dr[i];
				int dy = cy + dc[i];
				//한 레벨을 다 탐색 후 다음 단계로 이동
				if(dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != 0 && !visited[dx][dy]) {
					visited[dx][dy] = true;
					q.add(new int[] {dx, dy});
					hcnt++;
				}
			}
		}
	}
}