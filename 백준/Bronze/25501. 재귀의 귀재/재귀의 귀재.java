import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int chk;
	
	public static int recursion(String s, int l, int r) {
		if(l >= r) {
			chk = 1;
			return l+1;
		} else if(s.charAt(l) != s.charAt(r)) {
			chk = 0;
			return l+1;
		} else return recursion(s, l+1, r-1);
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			String S = br.readLine();
			
			chk=0;
			int a = recursion(S, 0, S.length()-1);
			
			System.out.println(chk + " " + a);
		}
		
	}
}