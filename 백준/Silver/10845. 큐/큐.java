import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //명령의 수
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String action = st.nextToken();
			if(action.equals("push")) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			else if(action.equals("pop")) {
				if(list.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(list.get(0));
					list.remove(0);
				}
			}
			else if(action.equals("size")) {
				System.out.println(list.size());
			}
			else if(action.equals("empty")) {
				if(list.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(action.equals("front")) {
				if(list.isEmpty()) System.out.println(-1);
				else System.out.println(list.get(0));
			}
			else {
				if(list.isEmpty()) System.out.println(-1);
				else System.out.println(list.get(list.size()-1));
			}
		}
	}
}