import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			//먼저 최소공약수
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a < b) {
				int tmp = a;
				a = b;
				b = tmp;
			}//더 큰 수를 a로 두기
			
			int gcd = recur(a, b);
			
			System.out.println(a * (b/gcd));
		}
	}
	//유클리드 알고리즘
	static int recur(int x, int y) {
		if(y == 0) return x;
		return recur(y, x%y);
	}
}