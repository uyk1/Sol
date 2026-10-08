import java.util.*;

class Solution {
    static int answer;
    static int[] hintTickets;
    
    public int solution(int[][] cost, int[][] hint) {
        answer = Integer.MAX_VALUE;
        hintTickets = new int[cost.length];
        
        // dfs > 각 스테이지에서 힌트권을 사는 경우와 사지 않는 경우
        dfs(0, 0, cost, hint);
        
        return answer;
    }
    
    private void dfs(int depth, int totalCost, int[][] cost, int[][] hint) {
        // 현재 스테이지 비용 처리 > 이전 스테이지들에서 구매한 티켓 사용
        // 티켓은 스테이지별로 최대 n-1개 사용 가능
        int ticketCount = Math.min(hintTickets[depth], cost.length - 1);
        int currCost = cost[depth][ticketCount];
        
        if(depth == cost.length - 1) {
            // 마지막 스테이지의 경우 티켓 구매 불가
            answer = Math.min(answer, totalCost + currCost);
            return;
        }
        
        // 티켓을 구매한 경우(hintTickets에 추가)            
        int ticketFee = hint[depth][0];
        for(int i = 1; i < hint[depth].length; i++) {
            hintTickets[hint[depth][i] - 1]++;
        }

        dfs(depth + 1, totalCost + currCost + ticketFee, cost, hint);

        // 티켓을 구매하지 않은 경우(복원)
        for(int i = 1; i < hint[depth].length; i++) {
            hintTickets[hint[depth][i] - 1]--;
        }
        dfs(depth + 1, totalCost + currCost, cost, hint);
    }
}