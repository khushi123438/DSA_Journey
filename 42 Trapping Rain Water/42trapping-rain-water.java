import java.util.*;

class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        int right[] = new int[n];
        right[n - 1] = height[n - 1];  
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int trapped = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(left[i], right[i]);
            trapped += waterLevel - height[i];
        }

        return trapped;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt(); 
        }

        int result = trap(height);    
        System.out.println(result);   
    }
}
