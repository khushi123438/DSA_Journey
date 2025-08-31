import java.util.Scanner;

public class Solution {

    
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; 

        for (int i = 1; i < strs.length; i++) {
            
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
       
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
