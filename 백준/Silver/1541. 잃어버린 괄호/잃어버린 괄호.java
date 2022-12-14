import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//-를 기준으로 나누고, 그 사이값들은 모두 더하여 계산
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int a = st.countTokens();
		int sum = 0;
		for(int i = 0; i < a; i++) {
			StringTokenizer stt = new StringTokenizer(st.nextToken(), "+");
			int b = stt.countTokens();
			for(int j = 0; j < b; j++) {
				//첫 묶음은 더하기
				if(i == 0) sum += Integer.parseInt(stt.nextToken());
				else sum -= Integer.parseInt(stt.nextToken());
			}
		}
		System.out.println(sum);
	}
}