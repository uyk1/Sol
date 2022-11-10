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
			dp[i] = arr[i];
			for(int j = 1; j <= i; j++) { //앞쪽 검사
				if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
					dp[i] = dp[j] + arr[i];
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 1001; i++) ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}