import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int year = 0;
		int e = 0;
		int s = 0;
		int m = 0;
		
		while(e != E || s != S || m != M) {
			if(e == 15) {
				e = 0;
			}
			if(s == 28) {
				s = 0;
			}
			if(m == 19) {
				m = 0;
			}
			e++;
			s++;
			m++;
			year++;
		}
		
		System.out.println(year);
	}
}