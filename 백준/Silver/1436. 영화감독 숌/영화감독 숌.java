import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1;
		int n = 666;
		while(cnt != N) {
			n++;
			if(chk(n)) {
				cnt++;
			}
		}
		System.out.println(n);
	}
	
	static boolean chk(int n) {
		String str = String.valueOf(n);
		int scnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '6') scnt++;
			else scnt = 0;
			if(scnt == 3) return true;
		}
		return false;
	}
}
