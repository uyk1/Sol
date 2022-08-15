import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> arr = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			arr.add(sc.nextInt(), i); 
		}
		
		for(int i = N - 1; i >= 0; i--) { 
			System.out.print(arr.get(i) + " ");
		}
		
	}
}
