import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        // 단어 - 노출 시점 - 상태
        List<String> words = new ArrayList<>(); // 단어 모음
        List<Integer> reveals = new ArrayList<>(); // 각 단어가 노출되는 시점
        
        int n = message.length(); // 메시지의 총 길이
        int idx = 0; // 단어 인덱스
        
        // 단어 파싱 및 마지막 공개 시점 계산
        for(String word : message.split(" ")) {
            int start = idx; // 단어 시작
            int end = idx + word.length() - 1; // 단어 끝
            
            int last = -1;
            
            // 스포일러 확인
            for(int i = 0; i < spoiler_ranges.length; i++) {
                int s = spoiler_ranges[i][0];
                int e = spoiler_ranges[i][1];
                
                // 현재 단어가 스포일러 영역에 일부라도 겹치면
                if(!(start > e || end < s)) {
                    last = i;
                }
            }
            
            words.add(word);
            reveals.add(last);
            
            idx = end + 2; // 공백 포함 다음 단어 시작 지점으로 인덱스 이동
        }
        
        // 일반 단어
        Set<String> normals = new HashSet<>();
        
        for(int i = 0; i < words.size(); i++) {
            // 스포일러에 포함된 단어가 아닌 경우 일반 단어로 등록
            if(reveals.get(i) == -1) normals.add(words.get(i));
        }
        
        // 중요한 단어 수 확인
        Set<String> opened = new HashSet<>(); // 스포일러 해제된 단어들

        // spoiler 클릭 순서대로 처리
        for (int t = 0; t < spoiler_ranges.length; t++) {

            for (int i = 0; i < words.size(); i++) {

                if (reveals.get(i) != t) continue;

                String w = words.get(i);

                if (!normals.contains(w) && !opened.contains(w)) {
                    answer++;
                }

                opened.add(w);
            }
        }
        
        return answer;
    }
}