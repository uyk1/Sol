import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = st.countTokens();
			String[] sentence = new String[size];
			for(int i = 0; i < size; i++) {
				String tmp = st.nextToken();
				char[] tmpword = new char[tmp.length()];
				for(int j = tmp.length() - 1; j >= 0; j--) sb.append(tmp.charAt(j));
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}