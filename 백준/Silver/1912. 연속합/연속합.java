import java.util.Scanner;

public class Main {
	static int n, ans;
	static int[] arr, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
		ans = Integer.MIN_VALUE;//최대값을 구하기 위한 초기화
		dp = new int[n];
		dp[0] = arr[0];
		for(int i = 1; i < n; i++) dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
		for(int i = 0; i < n; i++) ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
}
//현재까지의 연속합에 자신을 더한 값과, 자기 자신 값을 비교
//따라서 dp 배열에는 현재 인덱스까지의 연속합 최대값이 담김
//쉬운 문제라던데.. 발상 잘 안됨
