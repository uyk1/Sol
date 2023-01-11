import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		//큐를 이용
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) q.add(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		//원형 구조를 이룬다고 생각. 앞의 제거되지 않은 사람들은 맨 뒤로 보낸다.
		//출력 요건을 위해 1개는 남긴다.
		while(q.size() != 1) {
			for(int i = 0; i < K-1; i++) {
				int r = q.poll();
				q.add(r);
			}
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}