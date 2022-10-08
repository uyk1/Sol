import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[][] warning; //퀸을 놓을 수 없는 자리 확인
	static int cnt;
	//퀸의 활동반경 확인을 위한 델타. 행은 넘어갈 것이므로 우하, 하, 좌하를 확인
	static int[] dr = {1,1,1};
	static int[] dc = {1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		warning = new int[N][N];
		cnt = 0;
		
		chess(0);
		System.out.println(cnt);
	}
	
	static void chess(int idx) {
		if(idx == N) { //N-1행까지 다 놓았다면 카운트
			cnt++;
			return;
		}
		for(int i = 0; i < N;i++) {
			if(warning[idx][i] == 0) {
				for(int j = 0; j < N; j++) warning[idx][j] += 1;//현재 행 체크
				//아래 행들의 놓지 못하는 자리 체크 //델타
				for(int j = 0; j < 3; j++) {//삼방
					for(int k = 1; k < N-idx; k++) {//남은 행까지
						int dx = idx + dr[j]*k;
						int dy = i + dc[j]*k;
						if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
						warning[dx][dy] += 1;
					}
				}
				chess(idx+1);//놓고 다음 행으로
				//복구 //그냥 복구 시 이미 선택한 자리들의 영향도 지울 수 있음..
				for(int j = 0; j < N; j++) warning[idx][j] -= 1;
				for(int j = 0; j < 3; j++) {//삼방
					for(int k = 1; k < N-idx; k++) {//남은 행까지
						int dx = idx + dr[j]*k;
						int dy = i + dc[j]*k;
						if(dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
						warning[dx][dy] -= 1;
					}
				}
			}
		}
	}
}