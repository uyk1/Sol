import java.util.Scanner;

public class Main {
	static int[] A, tmp;
	static int cnt;
	static int ans;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //배열 A의 크기
		K = sc.nextInt(); //저장 횟수
		A = new int[N]; //정렬할 배열
		for(int i = 0; i < N; i++) A[i] = sc.nextInt();
		tmp = new int[N];
		cnt = 0;
		ans = -1;
		//원 배열, 첫 번째 인덱스, 마지막 인덱스
		merge_sort(A, 0, N-1);
		
		System.out.println(ans);
	}

	static void merge_sort(int[] arr, int p, int r) {
		if(cnt >= K) return; //K번째 저장되는 수를 구하고 나면 리턴
		if(p < r) { //만약 p보다 r이 작아지는 경우 이미 정렬이 끝난 것
			int q = (p + r) / 2; //p와 r의 중간
			merge_sort(arr, p, q);
			merge_sort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int i = p;
		int j = q + 1; //나눠진 뒷부분 첫번째 인덱스
		int t = 0;
		//각 파트에서 가져와 비교 후 tmp 배열에 오름차순으로 저장
		while(i <= q && j <= r) {
			if(arr[i] <= arr[j]) {
				tmp[t] = arr[i];
				i++;
			}else {
				tmp[t] = arr[j];
				j++;
			}
			t++;
		}
		//저장 후 남은 것들을 순서대로 저장
		while(i <= q) tmp[t++] = arr[i++];
		while(j <= r) tmp[t++] = arr[j++];
		//정렬된 배열을 원래 배열로 복사
		i = p;
		t = 0;
		while(i <= r) {
			cnt++;
			if(cnt == K) {
				ans = tmp[t];
				break;
			}
			arr[i++] = tmp[t++];
		}
	}
}