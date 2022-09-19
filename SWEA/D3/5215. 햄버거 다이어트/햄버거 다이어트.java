import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt(); // 재료 수
			int L = sc.nextInt(); // 제한 칼로리
			
			int[] taste = new int[N];
			int[] kcal = new int[N];
			
			for(int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			}
			
			int ans = 0;
			int staste, skcal;
			for(int i = 0; i < (1 << N); i++) {
				staste = 0;
				skcal = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) > 0) {
						staste += taste[j];
						skcal += kcal[j];
					}
					if(skcal > L) break;
					if(ans < staste) ans = staste;
				}
			}
			
		System.out.println("#" + t + " " + ans);
			
		} // T
	}
}
