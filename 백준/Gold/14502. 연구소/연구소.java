import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, ans;
	static int[][] map, copy;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copy = new int[N][M];//벽 세운 후 바이러스 확인
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		ans = 0;
		//입력
		
		wall(0, 0);
		
		System.out.println(ans);
	}
	
	static void wall(int idx, int sidx) {
		if(sidx == 3) {
			//벽 3개를 세운 후 바이러스 확산 체크
			//벽을 가진 카피 배열 생성, 이 카피 배열에 바이러스 실험
			for(int i = 0; i < N; i++) copy[i] = map[i].clone();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copy[i][j] == 2) virus(i, j);
				}
			}
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(copy[i][j] == 0) cnt++;
				}
			}
			ans = Math.max(ans, cnt);
			return;
		}
		for(int i = idx; i < N*M; i++) {
			int a = i/M;//행
			int b = i%M;//열
			if(map[a][b] == 0) {
				map[a][b] = 1;//벽 세우기(방문)
				wall(i+1, sidx+1);
				map[a][b] = 0;//복구
			}
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	//BFS
	static void virus(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		while(!q.isEmpty()) {
			int a = q.peek()[0];
			int b = q.poll()[1];
			for(int i = 0; i < 4; i++) {
				int dx = a + dr[i];
				int dy = b + dc[i];
				if(dx >= 0 && dx < N && dy >= 0 && dy < M) {
					if(copy[dx][dy] == 0) {
						copy[dx][dy] = 2;
						q.add(new int[] {dx, dy});
					}
				}
			}
		}
	}
}