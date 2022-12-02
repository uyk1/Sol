import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		// 이항계수 계산 후
		long cnt5 = five_calc(N) - five_calc(N-M) - five_calc(M);
		long cnt2 = two_calc(N) - two_calc(N-M) - two_calc(M);
		System.out.println(Math.min(cnt5, cnt2));
	}
	static long five_calc(long num) {
		int cnt = 0;
		while(num >= 5) {
			cnt += (num / 5);
			num /= 5;
		}
		return cnt;
	}
	static long two_calc(long num) {
		int cnt = 0;
		while(num >= 2) {
			cnt += (num / 2);
			num /= 2;
		}
		return cnt;
	}
}