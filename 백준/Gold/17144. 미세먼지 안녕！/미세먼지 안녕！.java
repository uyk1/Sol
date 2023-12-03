import java.util.Scanner;

public class Main {
	static int[][] map;
	static int R, C, T;
	static int ans = 0;
	
	// 상하좌우 탐색
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 행 수
		C = sc.nextInt(); // 열 수
		T = sc.nextInt(); // 시간(초)
		int cleaner = -2; // 공기청정기의 위치(행)
		
		map = new int[R][C]; // 미세먼지
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1 && cleaner == -2) cleaner = i;
			}
		}
		// T초 동안 진행 - 각 초당 미세먼지 확산, 공기청정기 동작이 동시에 발생 => 각 초 종료 후 tmpMap -> map에 반영
		for(int t = 0; t < T; t++) {
			// 변화 동시 반영을 위한 깊은 복사
			int[][] tmpMap = new int[R][C];
			for(int i = 0; i < R; i++) tmpMap[i] = map[i].clone();
			// 미세먼지 확산
			for(int x = 0; x < R; x++) {
				for(int y = 0; y < C; y++) {
					if(map[x][y] == 0 || map[x][y] == -1) continue;
					// 각 지점에서 사방탐색
					for(int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						int spread = map[x][y] / 5; // 확산시킬 미세먼지 양(map 기준)
						if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) continue;
						tmpMap[nx][ny] += spread;
						tmpMap[x][y] -= spread;
					}
				}
			}
			// 공기청정기 동작 - 상부(우상좌하), 하부(우하좌상)
			int[][] upperStep = {{0,1}, {-1,0}, {0,-1}, {1,0}};
			int[][] underStep = {{0,1}, {1,0}, {0,-1}, {-1,0}};
			// 상부
			int x = cleaner;
			int y = 0;
			int sign = 0; // 방향전환
			int tmp = -1; // 임시저장
			while(true) {
				if(sign == 3 && x == cleaner && y == 0) break; // 원래 자리로 돌아오면 정지
				
				int nx = x + upperStep[sign][0];
				int ny = y + upperStep[sign][1];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
					sign++;
					continue;
				}
				int tmpTmp = 0;
				if(tmp != -1) tmpTmp = tmp;
				tmp = tmpMap[nx][ny];
				if(tmp != -1) tmpMap[nx][ny] = tmpTmp;

				x = nx;
				y = ny;
			}
			// 하부
			x = cleaner + 1;
			y = 0;
			sign = 0;
			tmp = -1;
			while(true) {
				if(sign == 3 && x == cleaner + 1 && y == 0) break;
				
				int nx = x + underStep[sign][0];
				int ny = y + underStep[sign][1];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
					sign++;
					continue;
				}
				int tmpTmp = 0;
				if(tmp != -1) tmpTmp = tmp;
				tmp = tmpMap[nx][ny];
				if(tmp != -1) tmpMap[nx][ny] = tmpTmp;
				
				x = nx;
				y = ny;
			}
			// map에 반영
			for(int i = 0; i < R; i++) map[i] = tmpMap[i].clone();
		}
		// 미세먼지 합산
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != -1) ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
}
