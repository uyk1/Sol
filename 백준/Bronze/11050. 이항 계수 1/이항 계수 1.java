import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.println(fac(N) / (fac(K) * fac(N-K)));
	}
	//팩토리얼
	static int fac(int n) {
		if(n == 0) {
			return 1;
		}
		return n * fac(n-1);
	}
}