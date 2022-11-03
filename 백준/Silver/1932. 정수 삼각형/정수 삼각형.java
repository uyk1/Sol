import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//삼각형의 크기
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			for(int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		dp = new int[N][N];
		//삼각형을 이루는 수는 모두 0이상의 정수이므로 -1로 초기화
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
		//메서드 처음의 비교를 위해 맨 아래 행의 값을 기록
		for(int i = 0; i < N; i++) dp[N-1][i] = arr[N-1][i];
		System.out.println(search(0, 0));//행, 열
	}
	
	static int search(int r, int c) {
		//r이 마지막행에 도달하면 메인에서 이미 저장해 두었던 값을 반환
		if(r == N-1) {
			return dp[r][c];
		}
		//방문하지 않았다면
		if(dp[r][c] == -1) {
			//다음 행의 대각선 양쪽을 비교해 더 큰 값과 현재 위치의 값을 더해 dp배열에 저장(arr 배열에서)
			dp[r][c] = Math.max(search(r+1, c), search(r+1, c+1)) + arr[r][c];
		}
		return dp[r][c];
	}
}