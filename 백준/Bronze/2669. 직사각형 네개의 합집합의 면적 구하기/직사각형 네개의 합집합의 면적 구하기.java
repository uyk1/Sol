import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] map = new int[101][101];
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// 사각형 위치 파악 후 해당되는 영역 1로 변환
		for(int i = 0; i < 4; i++) {
			int[] sq = new int[4];
			for(int j = 0; j < 4; j++) {
				sq[j] = sc.nextInt();
			}
			for(int j = 0; j < sq[3] - sq[1]; j++) {
				for(int d = 0; d < sq[2] - sq[0]; d++) {
					map[sq[0]+d][sq[1]+j] = 1;
					
				}
			}
		}
		
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j] == 1) {
					sum += 1;
				}
			}
		}
		
		System.out.println(sum);
				
	}
}
