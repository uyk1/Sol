import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 캐시를 담기 위한 리스트
        List<String> cache = new ArrayList<>();
        
        // 실행시간 구하기
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase(); // 도시명
            
            // 캐시와 비교 -> true일 경우 캐시 히트
            if(cache.remove(city)) {
                // 캐시 히트
                answer++;
                cache.add(city); // 다시 맨 뒤로 넣기
            } else {
                // 캐시 미스
                answer += 5;
                cache.add(city);
                // 캐시가 다 찬 경우
                if(cache.size() > cacheSize) cache.remove(0); // 가장 오래 사용하지 않은 도시명 삭제
            }
        }
        
        return answer;
    }
}