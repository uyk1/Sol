import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> hm = new HashMap<>(); //종류, 개수
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); //필요 없으므로 날리기
				String str = st.nextToken();
				//만약 이미 해시맵의 키에 종류가 등록된 경우
				if(hm.containsKey(str)) hm.put(str, hm.get(str)+1);
				//없는 경우
				else hm.put(str, 1);
			}
			//입력
			int ans = 1;
			//각 종류에서 의상 하나씩만을 고를 것, 그 종류를 안 입는 경우까지 고려해 +1
			for(int val: hm.values()) ans *= (val+1);
			//그래도 아무것도 안 입으면 안 된다고 했으므로 -1
			System.out.println(ans-1);
		}
	}
}