import java.util.*;

class Solution {
    static List<Node>[] list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE; // 최소값 구하기
        
        // list 초기화
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        // 그래프 넣기
        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int to = fares[i][1];
            int weight = fares[i][2];
            
            // 반대방향도 넣어주기
            list[start].add(new Node(to, weight));
            list[to].add(new Node(start, weight));
        }
        
        // 다익스트라 실행
        int[] share = dijkstra(s, new int[n+1]);
        int[] toA = dijkstra(a, new int[n+1]);
        int[] toB = dijkstra(b, new int[n+1]);
        
        for(int i = 1; i <= n; i++) {
            // s, a, b 중 어느 한쪽이라도 i 지점에 도달할 방법이 없는 경우
            if(share[i] == Integer.MAX_VALUE || toA[i] == Integer.MAX_VALUE || toB[i] == Integer.MAX_VALUE) continue;
            answer = Math.min(answer, share[i] + toA[i] + toB[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int[] arr) {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[start] = 0;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int to = node.to;
            int weight = node.weight;
            // 비교
            if(arr[to] < weight) continue;
            // 연결된 노드들 확인
            for(Node o : list[to]) {
                if(arr[o.to] <= weight + o.weight) continue;
                arr[o.to] = weight + o.weight;
                pq.add(new Node(o.to, arr[o.to]));
            }
        }
        
        return arr;
    }
}

// Node 클래스 구현
class Node implements Comparable<Node> {
    int to;
    int weight;
    
    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}