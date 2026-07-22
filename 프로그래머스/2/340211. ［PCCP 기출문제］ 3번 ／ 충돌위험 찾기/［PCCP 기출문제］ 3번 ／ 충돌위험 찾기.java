import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int x = routes.length; // 로봇 수
        List<List<Integer>> allPositions = new ArrayList<>(); // 초 단위 각 로봇 위치 저장
        int maxT = 0; // 마지막 로봇 이동 종료 시점
        
        // 로봇 별 진행 위치 저장
        for(int[] route : routes) {
            List<Integer> positions = getPositions(points, route);
            allPositions.add(positions);
            maxT = Math.max(maxT, positions.size() - 1); // 마지막 로봇의 도착시간
        }
        
        // 시간 별 좌표 그룹핑 > 위험 상황 카운트
        int danger = 0;
        for(int t = 0; t <= maxT; t++) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            
            for(List<Integer> positions : allPositions) {
                // 로봇이 목표지점에 도착한 이후에는 카운트에 포함하지 않음
                if(t < positions.size()) {
                    int p = positions.get(t);
                    cntMap.merge(p, 1, (a, b) -> a + b);
                }
            }
            
            for(int cnt : cntMap.values()) {
                if(cnt > 1) danger++;
            }
        }
        
        return danger;
    }
    
    private List<Integer> getPositions(int[][] points, int[] route) {
        List<Integer> positions = new ArrayList<>();
        int r = points[route[0] - 1][0];
        int c = points[route[0] - 1][1];
        
        positions.add(encode(r, c)); // 시작위치
        
        for(int i = 1; i < route.length; i++) {
            int r2 = points[route[i] - 1][0]; // 이동할 지점
            int c2 = points[route[i] - 1][1];
            int sr = Integer.signum(r2 - r); // -1. 0. 1
            int sc = Integer.signum(c2 - c);
            
            // r 좌표 먼저 이동
            while(r != r2) {
                r += sr;
                positions.add(encode(r, c)); // 이동 위치 저장
            }
            
            while(c != c2) {
                c += sc;
                positions.add(encode(r, c)); // 이동 위치 저장
            }
        }
        
        return positions;
    }
    
    private int encode(int r, int c) {
        // r, c 최대가 100이므로 1000을 곱해 인코딩
        return r * 1000 + c;
    }
}