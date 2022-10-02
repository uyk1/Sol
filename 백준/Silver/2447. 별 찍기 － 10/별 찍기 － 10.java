import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] space;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		//1 사이즈가 될 때까지 채워갈 것.
		//사이즈, 현재 좌표
		star(N, 0, 0, false);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j != N-1) sb.append(map[i][j]);
				else sb.append(map[i][j]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void star(int n, int x, int y, boolean chk) {
		if(chk) {
			for(int i = x; i < x+n; i++) {
				for(int j = y; j < y+n; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
		if(n == 1) {
			if(!chk) map[x][y] = '*';
//			else map[x][y] = ' '; //위에서 이미 공백 처리함
			return;
		}
		for(int i = x; i < x+n; i += n/3 ) {
			for(int j = y; j < y+n; j += n/3) {
				//중간은 공백
				if(i == x+n/3 && j == y+n/3) star(n/3, i, j, true);
				else star(n/3, i, j, false);                                                   
			}
		}
	}
}