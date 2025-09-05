import java.util.*;

class Solution {
    public static void moveZeroes(int[] nums) {
        int pos = 0;

    
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos] = nums[i];
                pos++;
            }
        }

       
        for(int i = pos; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];

        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}
