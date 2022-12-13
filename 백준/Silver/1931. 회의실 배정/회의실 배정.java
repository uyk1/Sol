import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] plan = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			plan[i][0] = Integer.parseInt(st.nextToken());
			plan[i][1] = Integer.parseInt(st.nextToken());
		}
		//종료시간을 기준으로 정렬
		Arrays.sort(plan, new Comparator<int[]>() {
			//종료시간이 동일하면 시작시간이 빠른 순으로 정렬.
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int chk = 0; //직전 회의 종료시간
		for(int i = 0; i < N; i++) {
			//직전 회의 종료시간과 다음 회의 시작 시간을 비교
			if(chk <= plan[i][0]) {
				cnt++;
				chk = plan[i][1];
			}
		}
		System.out.println(cnt);
	}
}