import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt(); // 부먹 왕국의 도시 수
			int D = sc.nextInt(); // 이동 제한 거리
			// 인접 도시 간 거리는 1
			
			int[] map = new int[N];
			
			for(int i = 0; i < N; i++) map[i] = sc.nextInt();
			
			// 0번 인덱스부터 탐색. D의 범위 안에 첫 도시가 있는지 확인.
			// 없다면 cnt++;
			// 없다면 D-1번 인덱스 위치 값을 1로 변경. cnt = 0(초기화)
			// 첫 1부터 또 D 범위 내에 도시가 있는지 확인..
			// N-1 인덱스까지 확인.
			
			int cnt = 0; // 차원 관문이 없는 범위 확인
			
			int ans = 0; // 추가로 건설해야 할 차원관문의 최소 개수
			
			for(int i = 0; i < N; i++) {
				if(map[i] != 1) {
					cnt++;
					if(cnt == D) { // 차원 관문 도시 간 직접 연결
						map[i] = 1; // 차원 관문 건설
						ans++; // 필요 건설 수 증가
						cnt = 0; // 초기화
					}
				} else { // map[i] = 1 인 경우
					cnt = 0;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		} // T end
	} // main
}
