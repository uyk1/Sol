import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			dp = new int[N+1][M+1];
			// M개 중 N개 고르기
			System.out.println(cal(N, M));
		}
	}
	
	static int cal(int n, int m) {
		if(dp[n][m] > 0) return dp[n][m];
		if(n == 0 || m == n) return 1;
		return dp[n][m] = cal(n-1, m-1) + cal(n, m-1);
	}
}