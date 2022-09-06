import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int[] narr; // 조정된 배열
	public static boolean[] visited; // 방문했는지 확인
	public static int res; // 결과값
	
	// 재귀를 활용한 깊이 우선 탐색
	public static void dfs(int idx) {
		if(idx == N) {
			int sum = 0; // 각 조합의 합
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(narr[i]-narr[i+1]);
			}
			res = Math.max(res, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) { // arr[i]에 아직 방문하지 않은 경우
				visited[i] = true; // 방문했음을 기록
				narr[idx] = arr[i]; // 새로운 배열에 값 입력
				dfs(idx+1); // 다음 인덱스로 넘어감
				visited[i] = false; // 새로운 배열 생성 후 false로 초기화
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		narr = new int[N];
		visited = new boolean[N];
		res = 0; // 결과값 초기화
		dfs(0); // dfs 실행
		
		System.out.println(res);		
	}
}