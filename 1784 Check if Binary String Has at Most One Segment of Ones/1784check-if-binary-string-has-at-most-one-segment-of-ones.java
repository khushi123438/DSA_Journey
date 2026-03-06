class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroSeen = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                zeroSeen = true;
            }
            if(s.charAt(i) == '1' && zeroSeen) {
                return false;
            }
        }

        return true;
    }
}