import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = 0;
		int S = 0;
		StringBuilder sb = new StringBuilder();
		
		if(N >= M) {
			L = N;
			S = M;
		}else {
			L = M;
			S = N;
		}
		
		int cnt = 1;
		while(S / cnt != 1) {
			int mod = S / cnt;
			if(S % cnt == 0 && L % mod == 0) {
				sb.append(mod + "\n").append(S * (L/mod));
				System.out.println(sb);
				return;
			}
			cnt++;
		}
		sb.append(1 + "\n").append(S * L);
		System.out.println(sb);
	}
}