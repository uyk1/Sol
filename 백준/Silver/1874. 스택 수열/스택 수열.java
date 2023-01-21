import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //수열의 크기
		int[] arr = new int[n+1];
		for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>(); //스택
		StringBuilder sb = new StringBuilder(); //답 저장
		int target = 1; //현재 찾는 숫자의 arr 배열 위치
		for(int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");
			//찾는 위치에 도달하면 pop
			while(!stack.isEmpty() && stack.peek() == arr[target]) {
				stack.pop();
				sb.append("-\n");
				target++;
			}
		}
		//만약 스택이 비었다면 완료
		if(stack.isEmpty()) System.out.println(sb);
		else System.out.println("NO");
	}
}
// 같은 정수가 두 번 나오는 일은 없다..