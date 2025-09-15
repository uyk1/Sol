import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0; // 비밀코드로 가능한 정수 조합의 개수
        
        // 1 ~ n까지의 숫자에서 중복되지 않는 5개의 정수를 선택하는 모든 조합 생성
        List<int[]> combinations = generateCombinations(n, 5);
        
        // 위의 list에 대입하여 주어진 q 검증
        for(int[] combo : combinations) {
            if(isValidCombination(combo, q, ans)) answer++;
        }
        
        return answer;
    }
    
    /**
     * n개 중 k개를 선택하는 모든 조합 생성
     */
    private static List<int[]> generateCombinations(int n, int k) {
        List<int[]> result = new ArrayList<>();
        int[] current = new int[k];
        generateCombinationsHelper(1, n, k, 0, current, result); // 조합 생성
        
        return result;
    }
    
    private static void generateCombinationsHelper(int start, int n, int k, int index, int[] current, List<int[]> result) {
        if(index == k) {
            // 조합이 완성되면 추가
            result.add(current.clone());
            return;
        }
        
        for(int i = start; i < n + 1; i++) {
            current[index] = i;
            generateCombinationsHelper(i + 1, n, k, index + 1 , current, result);
        }
        
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