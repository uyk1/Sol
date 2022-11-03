import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//집의 수
		map = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		dp = new int[N][3];
		//집을 칠하는 비용은 자연수이므로 dp 초기화 필요 없음(0인 상태)
		//dp의 가장 마지막 행을 비교를 위해 채워놓기
		dp[N-1] = map[N-1];
		//행, 열
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) ans = Math.min(ans, cost(0, i));
		System.out.println(ans);
	}
	
	static int cost(int r, int c) {
		if(r == N-1) return dp[r][c];
		//방문하지 않았다면
		if(dp[r][c] == 0) {
			//다음 행의 비교값에서 작은 값을 현재 위치 map의 값과 더해 저장
			switch (c) {
			case 0:
				dp[r][c] = Math.min(cost(r+1, 1), cost(r+1, 2)) + map[r][c];
				break;
			case 1:
				dp[r][c] = Math.min(cost(r+1, 0), cost(r+1, 2)) + map[r][c];
				break;
			case 2:
				dp[r][c] = Math.min(cost(r+1, 0), cost(r+1, 1)) + map[r][c];
				break;
			}
		}
		return dp[r][c];
	}
}