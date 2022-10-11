import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	//연결된 집을 찾기 위한 델타 상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt; //단지 수 카운트
	static int hcnt; //단지 내 집 카운트
	static ArrayList<Integer> list = new ArrayList<>();
	
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
		cnt = 0; //단지 수 카운트
		//집이 존재하는 곳이고 아직 방문하지 않은 경우 탐색 시작
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//현재 좌표, 단지 내 집 카운트
				if(map[i][j] != 0 && !visited[i][j]) {
					cnt++;
					hcnt = 0;
					dfs(i, j); //현재 좌표
					list.add(hcnt);
				}
			}
		}
		Collections.sort(list); //오름차순 정렬
		System.out.println(cnt);
		for(int i : list) System.out.println(i);
	}//main
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		hcnt++;
		
		for(int i = 0; i < 4; i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];
			
			if(dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] != 0 && !visited[dx][dy]) {
				dfs(dx, dy);
			}
		}
	}
}