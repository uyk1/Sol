import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] route;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();//국가의 수
			M = sc.nextInt();//비행기 종류
			route = new int[N][N];
			for(int i = 0; i < M; i++) {
				route[sc.nextInt()-1][sc.nextInt()-1]++;
			}
			System.out.println(N-1);
		}
	}
}