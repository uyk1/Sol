import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		dp = new int[1001];
		for(int i = 1; i <= N; i++) {
			dp[i] = 1;
			for(int j = 1; j <= i; j++) {
				if(arr[i] < arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 1001; i++) ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}