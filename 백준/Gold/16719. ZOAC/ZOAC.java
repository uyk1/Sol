import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제 이해하는 데 한세월... 똑바로 읽자.
public class Main {
	static String str;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();//출력 문자
		visited = new boolean[str.length()];//방문 확인
		show(0, str.length()-1);//구간 경계
		System.out.println(sb);
	}
	
	//최초 문자 선택, 그 후 선택된 문자의 오른쪽, 왼쪽구간 순서로 재귀 반복
	static void show(int start, int end) {
		//교차되는 순간 리턴
		if(start > end) {
			return;
		}
		//구간에서 가장 먼저 선택될 문자 뽑기
		int selIdx = start;
		for(int i = start; i <= end; i++) {
			if(str.charAt(selIdx) > str.charAt(i)) selIdx = i;
		}
		visited[selIdx] = true;//방문처리
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(visited[i]) sb2.append(str.charAt(i));//행별 출력 생성
		}
		sb.append(sb2).append("\n");//최종출력을 위한 sb2 생성
		//오른쪽 구간, 왼쪽 구간 각각 재귀
		show(selIdx+1, end);
		show(start, selIdx-1);
	}
}