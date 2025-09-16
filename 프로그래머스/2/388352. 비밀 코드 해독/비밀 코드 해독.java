import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        return generateAndValidate(new int[5], 0, 1, n, q, ans);
    }
    
    private static int generateAndValidate(int[] current, int index, int start, int n, int[][] q, int[] ans) {
        if(index == 5) {
            // 조합이 완성되면 검증
            return isValidCombination(current.clone(), q, ans) ? 1: 0;
        }
        
        int count = 0; // 비밀 코드로 가능한 정수 조합의 수
        // 1부터 n까지 조합 생성
        for(int i = start; i < n + 1; i++) {
            current[index] = i;
            count += generateAndValidate(current, index + 1, i + 1, n, q, ans);
        }
        
        return count;
    }
    
    /**
     * 주어진 조합이 모든 조건을 만족하는지 검증
     */
    private static boolean isValidCombination(int[] combo, int[][] q, int[] ans) {
        // set 변환
        Set<Integer> comboSet = new HashSet();
        for(int n: combo) comboSet.add(n);
        
        for(int i = 0; i < q.length; i++) {
            Set<Integer> qSet = new HashSet();
            for(int n: q[i]) qSet.add(n);
                
            // 교집합
            Set<Integer> intersection = new HashSet(comboSet);
            intersection.retainAll(qSet);
            if(intersection.size() != ans[i]) return false;
        }
        
        return true;
    }
}