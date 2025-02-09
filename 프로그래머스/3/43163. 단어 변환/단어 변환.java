import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 탐색 간편화 및 중복제거를 위해 큐에 담기
        Queue<String> queue = new LinkedList<>(); // 변환 가능 단어 저장을 위한 큐
        Set<String> set = new HashSet<>(Arrays.asList(words)); // 단어 집합 set(중복 제거)
        
        // 만약 words에 target이 없다면 0 리턴
        if(!set.contains(target)) return 0;
        
        // begin
        queue.offer(begin);
        set.remove(begin);
        
        while(!queue.isEmpty()) {
            
            for(int i = 0; i < queue.size(); i++) {
                // 현재 단어
                String curr = queue.poll();
                // target 단어와 비교
                if(curr.equals(target)) {
                    return answer;
                }
                // target 단어와 일치하지 않는다면 변환
                for(String word: set.toArray(new String[set.size()])) {
                    if(check(curr, word)) {
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            
            answer++;
        }
        
        // 변환 실패
        return 0;
    }
    
    private boolean check(String curr, String word) {
        // 다른 문자의 개수 확인
        int cnt = 0;
        for(int i = 0; i < curr.length(); i++) {
            if(curr.charAt(i) != word.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        return cnt == 1;
    }
}