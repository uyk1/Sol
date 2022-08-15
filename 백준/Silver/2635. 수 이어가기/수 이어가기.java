import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0; // 만들어지는 음수 아닌 수들의 개수 확인
		
		int max = 0; // 가장 많이 만들어진 개수(세번째부터의 개수)
		
		int maxn = 1; // 두번째로 들어갈 수의 값. 양의 정수이므로 1부터 시작(특히 N이 1일 경우)
		
		for (int i = 1; i <= N; i++) {
			
			List<Integer> cal = new ArrayList<>();
			
			cal.add(N); // 첫 값 저장
			cal.add(i); // 두번째 값 저장
			
			int res = 0; // 뺄셈 결과
			
			while(res >= 0) {
				cal.add(cal.get(cal.size()-2)-cal.get(cal.size()-1));
				
				res = cal.get(cal.size()-1);
				
				cnt++; // 나중에 마지막 한 개는 빼주어야 함.
			}
			
			cnt--; // 마지막 음의 정수는 버림.
			
			if(max < cnt) {
				max = cnt;
				maxn = i;
			}
			
			cnt = 0; // 초기화
		} // for end
		
		List<Integer> ans = new ArrayList<>();
		
		ans.add(N); // 첫 값 저장
		ans.add(maxn); // 두번째 값 저장
		
		int res = 0;
		
		while(res >= 0) {
			ans.add(ans.get(ans.size()-2)-ans.get(ans.size()-1));
			
			res = ans.get(ans.size()-1);
		}
		
		System.out.println(max + 2); // N, maxn 결과도 포함시킴
		
		for(int i = 0; i < ans.size()-1; i++) { // 마지막 음수 제외
			
			System.out.printf("%d ", ans.get(i));
		}
		
	} // main
} // class
