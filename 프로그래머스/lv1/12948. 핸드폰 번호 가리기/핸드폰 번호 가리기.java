class Solution {
    public String solution(String phone_number) {
        String answer = phone_number.substring(phone_number.length() - 4);
        
        return "*".repeat(phone_number.length() - 4) + answer;
    }
}