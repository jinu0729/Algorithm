class Solution {
    public int solution(int a, int b) {
        int i1 = Integer.parseInt("" + a + b);
        int i2 = 2 * a * b;
        
        return Math.max(i1, i2);
    }
}