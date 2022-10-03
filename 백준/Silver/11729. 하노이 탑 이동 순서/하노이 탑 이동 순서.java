import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N, K;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //이동할 원판 개수
		K = 0;
		sb = new StringBuilder();
		//홀수일 때와 짝수일 때를 나누어 생각
		//홀수일 때는 목표 기둥으로, 짝수일 때는 목표 기둥 이외로 먼저 보내기
		//먼저 가장 큰 원판을 목표한 기둥으로 옮겨야 함
		//3으로 이동해야할 원판의 개수, 시작, 중간, 목표 기둥
		//재귀로 구현할 것 // 그런데 이게 점화식을 모르면 풀 수 있는 문제인가..?
		//K를 하노이 점화식을 통해 계산
		// 1 > 1 2 > 3 3 > 7
		K = (int) (Math.pow(2, N) - 1);
		sb.append(K + "\n");
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int a, int b, int c) {
		if(n == 1) {
			sb.append(a + " " + c + "\n");
			return;
		}
		//n-1개의 원판을 2번 기둥으로
		hanoi(n-1, a, c, b);
		//남은 가장 큰 원판을 3번 기둥으로
		sb.append(a + " " + c + "\n");
		//n-1개의 원판을 3번 기둥으로
		hanoi(n-1, b, a, c);
	}
}