import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b  =sc.nextInt();
		int c = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		int r1 = (a+b)%c;
		int r2 = ((a%c)+(b%c))%c;
		int r3 = (a*b)%c;
		int r4 = ((a%c)*(b%c))%c;
		
		sb.append(r1).append("\n").append(r2).append("\n")
		.append(r3).append("\n").append(r4).append("\n");
		
		System.out.println(sb);
	}
}
