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
		dp = new int[1001];//각 자리까지의 최장 증가 부분수열의 길이를 저장할 배열
		//수열 A의 수를 하나씩 탐색
		for(int i = 1; i <= N; i++) {
			dp[i] = 1; // 부분수열의 최소 숫자는 1
			for(int j = 1; j <= i; j++) { // 자기 앞쪽 탐색
				//i번째 숫자보다 j번째 숫자가 더 작고, i번째까지의 dp값보다 j번째의 dp값 +1이 큰 경우.
				//이는 이미 앞쪽부터 순차적으로 계산되어왔으므로 가능
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < 1001; i++) ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}