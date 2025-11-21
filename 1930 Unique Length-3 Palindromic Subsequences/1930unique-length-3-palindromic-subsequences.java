class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        Set<Character> uniqueChars = new HashSet<>();

        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

         for (char c : uniqueChars) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            
            if (first < last) { 
                Set<Character> middleChars = new HashSet<>();
                
                
                for (int i = first + 1; i < last; i++) {
                    middleChars.add(s.charAt(i));
                }
                
                count += middleChars.size(); 
            }
        }
        
        return count;

    }
}