import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); //조약돌들의 색상 종류 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] colors = new int[M]; //색상별 조약돌 수
		int N = 0; //조약돌 총 개수
		for(int i = 0; i < M; i++) {
			colors[i] = Integer.parseInt(st.nextToken());
			N += colors[i];
		}
		int K = Integer.parseInt(br.readLine()); //선택할 조약돌 수
		//총 경우의 수
		double total = 1;
		for(int i = 0; i < K; i++) total *= (N-i);
		//뽑은 조약돌이 모두 같은 색상인 경우의 수
		double same = 0;
		for(int i = 0; i < M; i++) {
			if(colors[i] < K) continue;
			else {
				//개수가 충분하다면, 경우의 수 구하기
				double tmp = 1;
				for(int j = 0; j < K; j++) tmp *= (colors[i]-j);
				same += tmp;
			}
		}
		System.out.println(same/total);
	}
}
//double의 적용에 유의..