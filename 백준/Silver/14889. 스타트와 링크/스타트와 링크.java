import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] sel; // true와 false로 팀 구별을 할 것
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		ans = Integer.MAX_VALUE; // 최소값을 위한 초기화
		sel = new boolean[N];

		// 총 인원 N명의 인덱스, 뽑아야할 인원 N/2명의 인덱스
		team(0, 0);

		System.out.println(ans);
	}

	public static void team(int idx, int sidx) {
		if (sidx == N / 2) {
			calc();
			return;
		}
		if (idx == N)
			return;

		sel[idx] = true;
		team(idx+1, sidx +1); // 뽑고 가기
		sel[idx] = false;
		team(idx+1, sidx); // 안 뽑고 가기

	}

	public static void calc() {
		int sumA = 0; // 능력치 합계를 임시로 구하기 위한 변수
		int sumB = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && sel[i] && sel[j]) {
					sumA += map[i][j];
				}
				else if(i != j && !sel[i] && !sel[j]) {
					sumB += map[i][j];
				}
			}
		}
		int ab = Math.abs(sumA - sumB);
		ans = Math.min(ans, ab);
	}
}
