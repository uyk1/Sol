class Solution {
    static boolean[] visit; // 방문 처리
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    static void dfs(int currK, int[][]dungeons, int depth) {
        //모든 노드를 다 확인해야 함(최대 탐험 수)
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && currK >= dungeons[i][0]) {
                visit[i] = true;
                dfs(currK - dungeons[i][1], dungeons, depth+1);
                visit[i] = false;
            }
        }
        //조건에 부합할 때에만 depth를 증가시켰으므로
        //여기서 depth는 이번 분기에 탐험한 던전의 수
        answer = Math.max(answer, depth);
    }
}
// k : 피로도
// {최소 필요 피로도, 소모 피로도}
// dfs 혹은 bfs 방식으로 모든 경우의 수를 탐색