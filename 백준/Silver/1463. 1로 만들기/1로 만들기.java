import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		System.out.println(find(N));
	}
	
	static int find(int n) {
		if(dp[n] != 0) return dp[n];
		if(n == 1) return 0;
		if(dp[n] == 0) {
			//3으로 나눴을 때의 조합과 2로 나눴을 때의 조합 둘 다 고려
			if(n % 3 == 2 && n % 2 == 0) {
				dp[n] = Math.min(find(n-1), find(n/2)) + 1;
			}
			else if(n % 3 == 2 && n % 2 == 1) {
				dp[n] = find(n-1)+ 1;
			}
			else if(n % 3 == 1 && n % 2 == 0) {
				dp[n] = Math.min(find(n-1), find(n/2)) + 1;
			}
			else if(n % 3 == 1 && n % 2 == 1) {
				dp[n] = find(n-1)+ 1;
			}
			else if(n % 3 == 0 && n % 2 == 0) {
				dp[n] = Math.min(find(n/3), find(n/2)) + 1;
			}
			else if(n % 3 == 0 && n % 2 == 1) {
				dp[n] = Math.min(find(n/3), find(n-1)) + 1;
			}
		}
		return dp[n];
	}
}