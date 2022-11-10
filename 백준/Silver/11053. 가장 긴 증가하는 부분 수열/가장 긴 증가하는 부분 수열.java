import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
		Arrays.fill(dp, 1001); //차후 반복문에서 계산을 위하여 최대 Ai+1 값으로 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i] <= dp[j]) {
					dp[j] = arr[i];
					break;
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			if(dp[i] == 1001) break;
			ans++;
		}
		System.out.println(ans);
	}
}