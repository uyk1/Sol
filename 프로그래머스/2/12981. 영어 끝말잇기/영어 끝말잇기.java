import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        // 이미 말한 단어를 담는 리스트
        List<String> list = new ArrayList<>();
        
        int num = 1; // 현재 말할 사람의 순서
        for(int i = 0; i < words.length; i++) {
            // 앞사람이 말한 마지막 문자와 첫 문자가 일치하는지 확인
            if(i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[] {num, i / n + 1};
            }
            // 이전에 등장했던 단어인지 확인
            if(list.contains(words[i])) {
                return new int[] {num, i / n + 1};
            } else {
                list.add(words[i]);
            }
            
            if(num == n) num = 1;
            else num++;
        }
        
        // 탈락자가 없는 경우
        return new int[] {0, 0};
    }
}