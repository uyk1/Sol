class Solution {
    /*
    그래프 종류는 도넛, 막대, 8자.
    도넛 - 시작 정점 외에 중복없이 모두 방문(시작 정점으로 회귀)
    막대 - 시작 정점에서 끝 정점까지 일방 통행
    8자 - 크기가 동일한 2개의 도넛 모양 그래프에서 정점을 하나씩 골라 결합(결합부는 2개의 간선 도착지, 2개의 간선 출발지가 됨)
    신규 정점을 하나 추가로 생성하여, 여러 그래프로 간선을 내보냄
    신규 정점의 경우 간선의 도착지가 되는 경우는 없음!
    정점의 개수는 1개 이상, 1000000 이하.
    각 그래프의 정점 특성을 파악해 그래프 찾기.
    */
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        // 진입, 진출 차수 정점별로 확인
        int[] outDegrees = new int[1000001];
        int[] inDegrees = new int[1000001];
        
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            outDegrees[a]++;
            inDegrees[b]++;
        }
        
        for(int i = 1; i <= 1000000; i++) {
            int a = outDegrees[i];
            int b = inDegrees[i];
            
            if(a >= 2 && b == 0) answer[0] = i; // 생성 정점
            else if(a == 0 && b != 0) answer[2]++; // 막대
            else if(a == 2 && b >= 2) answer[3]++; // 8자
        }
        
        // 도넛 개수는 생성 정점의 진출 차수에서 막대, 8자 그래프 개수 빼기
        answer[1] = outDegrees[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}