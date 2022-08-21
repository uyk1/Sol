import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 학생 수
		
		int K = sc.nextInt(); // 방 최대 정원
		
		int[][] cnt = new int[6][2]; // 6학년, 남녀
		
		for(int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별 0 1
			int Y = sc.nextInt(); // 학년 1 - 6
			
			cnt[Y - 1][S]++; // 조건에 부합하는 학생 수 카운트 // Y-1 인 이유는 인덱스 
		}
		
		int ans = 0; // 필요한 방 수
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				if(cnt [i][j] > 0 && cnt[i][j] <= K) {
					ans++;
				} else if(cnt[i][j] > K) { // cnt[i][j]가 0인 경우 배제 
					
					if(cnt[i][j] % K != 0) {
						ans += cnt[i][j] / K + 1;
					} else {
						ans += cnt[i][j] / K;
					}
				}
			} // for j end
		} // for i end
		
		System.out.println(ans);
		
	} // main
}