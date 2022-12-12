import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //동전의 개수
		K = Integer.parseInt(st.nextToken()); //목표값
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		//입력
		int cnt = 0;
		int res = K;
		for(int i = N-1; i >= 0; i--) {
			if(res < arr[i]) continue;
			if(res / arr[i] == 0) break;
			if(res / arr[i] > 0) {
				int m = res / arr[i];
				cnt += m;
				res -= m * arr[i];
			}
		}
		System.out.println(cnt);
	}
}