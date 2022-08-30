import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int i = 0;
		while(true) {
			int chk = ++i%5;
			if(chk == 1) {
				System.out.println(A+B);
			} else if(chk == 2) {
				System.out.println(A-B);
			} else if(chk == 3) {
				System.out.println(A*B);
			} else if(chk == 4) {
				System.out.println(A/B);
			} else {
				System.out.println(A%B);
				return;
			}
		}
	}
}