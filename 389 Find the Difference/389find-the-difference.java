class Solution {
     public static char findTheDifference(String s, String t) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return c;
        }
        return ' '; 
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        String t;
        t = sc.nextLine();

        findTheDifference(s,t);
    }
}