import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			int cnt = 0;
			boolean chk = true;
			for(int j = 0; j < arr.length; j++) {
				if(arr[0] == ')') {
					chk = false;
					break;
				}
				if(arr[j] == '(') {
					cnt++;
				}else {
					if(cnt > 0) {
						cnt--;
					} else {
						chk = false;
						break;
					}
				} 
			}
			if(!chk || cnt!=0) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
	}
}