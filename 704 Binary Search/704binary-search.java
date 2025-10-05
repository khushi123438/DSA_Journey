class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return bsf(nums, 0, n - 1, target);
    }

    public int bsf(int[] nums, int l, int r, int target) {
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;

        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return bsf(nums, mid + 1, r, target); 
        else
            return bsf(nums, l, mid - 1, target);
    }
}
