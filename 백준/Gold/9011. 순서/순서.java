import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		outer: for (int t = 1; t <= T; t++) {
			n = sc.nextInt();// 정수의 개수
			arr = new int[n + 1];// R배열
			for (int i = 1; i <= n; i++)
				arr[i] = sc.nextInt();
			sel = new boolean[n + 1];// 1부터 n까지를 받기 위해 n+1
			// 입력 끝
			for (int i = n; i > 0; i--) {
				int cnt = 0;
				boolean sign = false;// S 찾기 불가능 여부 체크
				for (int j = 1; j <= n; j++) {
					if (!sel[j])
						cnt++;
					if (cnt == arr[i] + 1) {
						arr[i] = j;
						sel[j] = true;
						sign = true;
						break;
					}
				}
				if(!sign) {
					System.out.println("IMPOSSIBLE");
					continue outer;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; i++) sb.append(arr[i]).append(" ");
			System.out.println(sb);
		}//T
	}//main
}