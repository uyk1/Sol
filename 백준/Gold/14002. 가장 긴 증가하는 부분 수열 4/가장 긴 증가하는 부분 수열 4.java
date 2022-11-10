import java.util.Scanner;
import java.util.Stack;

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
		
		//앞부분 검사 방식으로 풀자
		int cnt = 1;
		for(int i = 0; i < N ; i++) {
			dp[i] = 1; //초기화
			for(int j = 0; j <= i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					cnt = Math.max(cnt, dp[i]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		
		//역추적
		int tmp = cnt;
		Stack<Integer> st = new Stack<>(); //역순으로 출력하기 위해 스택 이용
		for(int i = N-1; i >= 0; i--) {
			if(dp[i] == tmp) {
				st.push(arr[i]);
				tmp--; //찾는 인덱스 1 감소
			}
		}
		while(!st.isEmpty()) sb.append(st.pop()).append(" ");
		System.out.println(sb);
	}
}