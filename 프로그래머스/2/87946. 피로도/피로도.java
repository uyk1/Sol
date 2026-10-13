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
        answer = -1;
        visited = new boolean[dungeons.length];
        
        // 순열(중복 X) DFS
        dfs(new ArrayList<Integer>(), k, dungeons);
        
        return answer;
    }
    
    private void dfs(ArrayList<Integer> list, int k, int[][] dungeons) {
        if(list.size() == dungeons.length) {
            // 던전 순열이 완성되면 탐험 시작
            explore(list, k, dungeons);
            return;
        }
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            list.add(i);
            
            dfs(list, k, dungeons);
            
            visited[i] = false;
            list.remove(Integer.valueOf(i));
        }
    }
    
    private void explore(ArrayList<Integer> list, int k, int[][] dungeons) {
        int cnt = 0;
        int ap = k;
        
        for(int i : list) {
            if(dungeons[i][0] > ap) continue;
            
            cnt++;
            ap -= dungeons[i][1];
        }
        
        answer = Math.max(answer, cnt);
    }
}