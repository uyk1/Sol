import java.util.*;

class Solution {
    /*
        최소 필요 피로도 : 해당 던전 탐험을 위해 보유하고 있어야 하는 피로도
        소모 피로도 : 해당 던전 탐험 시 소모되는 피로도
        각 던전은 하루에 한 번씩만 탐험 가능
        1 <= k(현재 피로도) <= 5000 자연수
        1 <= 던전 수 <= 8
        유저는 "최대한 많은" 던전을 탐험하고자 함. => 유저가 탐험할 수 있는 최대 던전 수 도출
        던전 진입 순서가 달라지면 탐험 가능한 던전 수가 달라질 수 있음(최소 필요 / 소모 피로도 간 차이로)
    */
    
    private int answer;
    private boolean[] visited;
        
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        // 순열(중복 X) DFS
        dfs(0, 0, k, dungeons);
        
        return answer;
    }
    
    private void dfs(int depth, int cnt, int k, int[][] dungeons) {
        if(depth == dungeons.length) {
            // 던전 탐험이 끝나면 answer 갱신
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            
            if(dungeons[i][0] > k) {
                dfs(depth + 1, cnt, k, dungeons);
            } else {
                dfs(depth + 1, cnt + 1, k - dungeons[i][1], dungeons);
            }
            
            visited[i] = false;
        }
    }
}