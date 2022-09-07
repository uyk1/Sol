import java.util.Scanner;

public class Main {
	public static int N;
	public static int f; // 팩토리얼 결과
	public static int idx;
	
	public static void factorial(int n) {
		if(n == 0) {
			return;
		}
		
		f *= n;
		factorial(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		f = 1;
		
		if(N != 0)
			factorial(N);
		
		System.out.println(f);
	}
}