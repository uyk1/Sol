import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;//앞쪽 검사 결과 저장
	static int[] dp2;//뒤쪽

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		dp2 = new int[N];
		for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
		//수열 A의 수를 하나씩 탐색(앞쪽)
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		//(뒤쪽)
		for(int i = N-1; i >= 0; i--) {
			dp2[i] = 1;
			for(int j = N-1; j > i; j--) {
				if(arr[i] > arr[j] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[j] + 1;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < N; i++) ans = Math.max(ans, dp[i] + dp2[i] - 1);
		System.out.println(ans);
	}
}