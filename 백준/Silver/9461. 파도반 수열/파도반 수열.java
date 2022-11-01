import java.util.Scanner;

public class Main {
	static int N;
	static long[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			if(N == 1 || N == 2 || N == 3) {
				sb.append(1).append("\n");
				continue;
			}
			arr = new long[N+1];
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			sb.append(P(N)).append("\n");
		}
		System.out.println(sb);
	}
	
	static long P(int n) {
		if(arr[n] != 0) return arr[n];
		return arr[n] = P(n-3) + P(n-2);
	}
}
//파도반 수열은 100번째 정도 가면 이미 int 범위를 초과