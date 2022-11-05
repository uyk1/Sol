import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //계단의 높이
		arr = new int[301];//시작지점을 0번인덱스로 간주
		dp = new int[301];//계단은 최대 300개
		for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
		dp[1] = arr[1];
		dp[2] = arr[2]+arr[1];
		//dp[3]계산.. 여기서도 1번과 2번을 비교해 주어야 함
		dp[3] = Math.max(arr[1], arr[2])+arr[3];
		for(int i = 4; i <= N; i++) {
			//dp[i-1]이 아니라 arr[i-1]이어야 함에 유의
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
		}
		System.out.println(dp[N]);
	}
}