import java.util.*;

class Solution {
    static ArrayList<Integer>[] tree;
    static int answer;
    static boolean[] visit;
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        //인접 리스트로 트리 받기
        tree = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int[] is: wires) {
            //양방향으로 추가
            tree[is[0]].add(is[1]);
            tree[is[1]].add(is[0]);
        }
        //DFS를 활용해 계산 //전선 하나씩 건너뛰어 가며 확인
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            visit = new boolean[n+1];
            visit[1] = true;
            dfs(1, a, b);
            //DFS 완료 후 방문한 송전탑을 확인 //연결이 끊긴 지점까지만 방문함
            int cnt = 0;
            for(boolean bl: visit) if(bl) cnt++;
            answer = Math.min(answer, Math.abs(n-(2*cnt)));
        }
        
        return answer;
    }
    
    //현재 위치한 송전탑, 무시할 전선 a <-> b
    static void dfs(int curr, int a, int b) {
        for(int next : tree[curr]) {
            //무시
            if(curr == a && next == b || curr == b && next == a) continue;
            //재귀 호출
            if(!visit[next]) {
                visit[next] = true;
                dfs(next, a, b);
                // visit[next] = false;
            }
        }
    }
}