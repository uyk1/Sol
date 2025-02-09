import java.util.*;

class Solution {
    private static boolean[] visited; // 티켓 사용 여부 확인
    private static ArrayList<String> list = new ArrayList<>(); // 도출된 여행경로들을 담을 리스트
    
    public String[] solution(String[][] tickets) {
        // 주어진 항공권을 모두 이용해야 함.
        // 따라서, 중복 제거 없이 완전 탐색 진행 후 정렬을 통해 답 최종 도출
        visited = new boolean[tickets.length];
        // dfs 완전 탐색
        dfs(0, "ICN", "ICN", tickets);
        // 정렬
        Collections.sort(list);
        // 배열로 바꾸어 정답 리턴
        return list.get(0).split(" ");
    }
    
    private static void dfs(int depth, String now, String path, String[][] tickets) {
        // depth가 티켓의 수와 동일해지면 여행 경로로 추가
        if(depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            // 만약 사용되지 않은 티켓이고 출발지가 현재 위치와 일치한다면 방문
            if(!visited[i] && now.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}