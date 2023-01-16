import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //백준이 들은 과목 개수
		//성적 A+ ~ F 총 13개
		double[] grade = {4.3, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0};
		double totalGrade = 0;
		int totalTime = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int t = Integer.parseInt(st.nextToken()); //시수
			totalTime += t;
			String G = st.nextToken();
			if(G.equals("A+")) totalGrade += t*grade[0]; //이 과목의 시수*학점
			else if(G.equals("A0")) totalGrade += t*grade[1];
			else if(G.equals("A-")) totalGrade += t*grade[2];
			else if(G.equals("B+")) totalGrade += t*grade[3];
			else if(G.equals("B0")) totalGrade += t*grade[4];
			else if(G.equals("B-")) totalGrade += t*grade[5];
			else if(G.equals("C+")) totalGrade += t*grade[6];
			else if(G.equals("C0")) totalGrade += t*grade[7];
			else if(G.equals("C-")) totalGrade += t*grade[8];
			else if(G.equals("D+")) totalGrade += t*grade[9];
			else if(G.equals("D0")) totalGrade += t*grade[10];
			else if(G.equals("D-")) totalGrade += t*grade[11];
			else totalGrade += t*grade[12]; //사실 그냥 0
		}
		System.out.println(String.format("%.2f", totalGrade/totalTime));
	}
}