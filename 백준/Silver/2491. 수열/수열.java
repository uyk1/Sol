import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어진 수열의 길이

		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		int max = 1; // 가장 긴 연속 증감 수열의 길이
		
		int cnt = 1; // 자기 자신부터 시작
		
		// 증가하는 수열 찾기
		
		// 두개씩 비교해서 확인, cnt 조정으로 max와 비교. 
		
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] <= nums[i+1]) {
				cnt++;
			}else {
				if(max < cnt) {
					max = cnt;
				}
				cnt = 1; // 한번 걸리면 비교 후 초기화
			}
			if(max < cnt) { // 마지막 한번도 확인할 수 있게
				max = cnt;
			}
		}
		
		// 감소하는 수열 찾기(위와 부등호만 다르게)
		
		cnt = 1; // 초기화
		
		for(int i = 0; i < N - 1; i++) {
			if(nums[i] >= nums[i+1]) {
				cnt++;
			}else {
				if(max < cnt) {
					max = cnt;
				}
				cnt = 1;
			}
			if(max < cnt) {
				max = cnt;
			}
		}

		System.out.println(max);
	}
}
