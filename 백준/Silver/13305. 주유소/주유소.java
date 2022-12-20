import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] length = new int[N - 1];
		int[] price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		//만약 다음 도시에서 기름 가격이 더 비싸면 미리 주유해야하므로 가격을 바꾸어 두기
		for(int i = 0; i < N-2; i++) {
			if(price[i] < price[i+1]) price[i+1] = price[i];
		}
		//범위 고려
		long ans = 0;
		//마지막 도시의 가격은 고려할 필요 없음
		for(int i = 0; i < N-1; i++) {
			ans += length[i] * (long) price[i];
		}
		System.out.println(ans);
	}
}