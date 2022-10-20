import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//현재 행, 열
		sudoku(0, 0);
	}
	
	//한 행씩 검사
	static void sudoku(int r, int c) {
		if(r == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(j != 8) sb.append(map[i][j] + " ");
					else sb.append(map[i][j] + "\n");
				}
			}
			System.out.println(sb);
			System.exit(0); //하나의 답안을 출력하고 종료
			return;
		}
		if(c == 9) {
			//한 행을 채우고 다음 행 첫 열로
			sudoku(r + 1, 0);
			return;
		}
		//0이면 1부터 9까지 넣어보면서 확인 //스도쿠 생성에 실패하는 경우는 없음
		if(map[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				//행, 열, 확인할 값
				if(chk(r, c, i)) {
					map[r][c] = i;
					sudoku(r, c+1);
				}
			}
			map[r][c] = 0; //찾는 값이 아니면 복구
		}
		//0이 아니면 다음 열로
		else sudoku(r, c+1);
	}
	
	static boolean chk(int r, int c, int v) {
		//행 확인(동일한 수가 있는지)
		for(int i = 0; i < 9; i++) {
			if(i != c && map[r][i] == v) return false;
		}
		//열 확인
		for(int i = 0; i < 9; i++) {
			if(i != r && map[i][c] == v) return false;
		}
		//박스 확인 //3으로 나눈 몫에 다시 3을 곱해 확인할 박스 좌표 설정
		int sr = (r/3)*3;
		int sc = (c/3)*3;
		for(int i = sr; i < sr+3; i++) {
			for(int j = sc; j < sc+3; j++) {
				if(i != r && j != c && map[i][j] == v) return false;
			}
		}
		return true;
	}
}