import java.util.*;

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, set, 0, memo);
    }
    
    private boolean dfs(String s, Set<String> set, int start, Boolean[] memo) {
        
        if(start == s.length()) return true;
        
        if(memo[start] != null) return memo[start];
        
        for(int end = start + 1; end <= s.length(); end++) {
            
            if(set.contains(s.substring(start, end)) 
               && dfs(s, set, end, memo)) {
                
                return memo[start] = true;
            }
        }
        
        return memo[start] = false;
    }
}
