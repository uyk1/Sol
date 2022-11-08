import java.util.Scanner;

public class Main {
	static int N;
	static int[][] dp;
	static int MOD = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1][11];//아래서 계산상 편의를 위해 11까지(0~9까지 맨 마지막 1의 자리 값)
		//길이가 1일때를 1로 초기화
		for(int i = 1; i <= 9; i++) dp[1][i] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1; j <= 9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
			}
		}
		//dp[N][10]은 제외하고 더하기
		long ans = 0;
		for(int i = 0; i <= 9; i++) {
			ans += dp[N][i];//N의 길이이고 1의 자리 값이 i인 경우의 수 더하기
			ans %= MOD;
		}
		System.out.println(ans);
	}
}