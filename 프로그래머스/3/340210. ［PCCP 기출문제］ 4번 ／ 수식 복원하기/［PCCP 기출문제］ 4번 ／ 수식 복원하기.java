import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        
        // 유효한(식을 성립시키는) 진법
        List<Integer> validBases = new ArrayList<>();
        
        // 주어진 식들을 기반으로 유효한 진법 값을 확인
        for(int base = 2; base <= 9; base++) {
            if(isValidBase(expressions, base)) validBases.add(base);
        }
        
        List<String> xList = new ArrayList<>();
        
        for(String expr : expressions) {
            String[] arr =  expr.split(" ");
        
            String a = arr[0];
            String sig = arr[1]; // + -
            String b = arr[2];
            String x = arr[4]; // 결과
            
            if(!x.equals("X")) continue;
            
            Set<String> xSet = new HashSet<>(); // 각 베이스별 계산 결과 저장(중복 x)
            
            for(int base : validBases) {
                int aVal = Integer.parseInt(a, base);
                int bVal = Integer.parseInt(b, base);
                int xVal = sig.equals("+") ? aVal + bVal : aVal - bVal;
                
                xSet.add(Integer.toString(xVal, base));
            }
            
            String str = a + " " + sig + " " + b + " = " + (xSet.size() == 1 ? xSet.iterator().next() : "?");
            
            xList.add(str);
        }
        
        return xList.toArray(new String[0]);
    }
    
    private Boolean isValidBase(String[] expressions, int base) {
        
        for(String expr : expressions) {
            String[] arr =  expr.split(" ");
        
            String a = arr[0];
            String sig = arr[1]; // + -
            String b = arr[2];
            String x = arr[4]; // 결과
            
            for(String token : new String[] {a, b}) {
                for(char c : token.toCharArray()) {
                    // 분해한 각 자릿수가 베이스보다 크면, 해당 진법은 유효하지 않음
                    if(Character.digit(c, 10) >= base) return false;
                }
            }

            if(x.equals("X")) continue;
            
            for(String token : new String[] {x}) {
                for(char c : token.toCharArray()) {
                    // 분해한 각 자릿수가 베이스보다 크면, 해당 진법은 유효하지 않음
                    if(Character.digit(c, 10) >= base) return false;
                }
            }
            
            // 계산식 확인
            int aVal = Integer.parseInt(a, base);
            int bVal = Integer.parseInt(b, base);
            int xVal = Integer.parseInt(x, base);
            boolean flag = sig.equals("+") ? aVal + bVal == xVal : aVal - bVal == xVal;
            
            if(!flag) return false;
        }
        
        return true;
    }
}