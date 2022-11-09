import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[10001];
		dp = new int[10001];
		for(int i = 1; i <= N; i++) arr[i] = sc.nextInt();
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1], arr[2]) + arr[3];
		dp[4] = Math.max(dp[1] + arr[3],dp[2]) + arr[4];
		for(int i = 5; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1], Math.max(dp[i-2], dp[i-4] + arr[i-1])) + arr[i];
		}
		int ans = Math.max(dp[N-1], dp[N]);//세 잔 연속이 불가능 하므로 맨 마지막 두 잔에 대해 검사
		System.out.println(ans);
	}
}