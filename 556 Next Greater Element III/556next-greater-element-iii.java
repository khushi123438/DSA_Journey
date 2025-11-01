class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = (n + "").toCharArray();
        int i = digits.length - 2;

        // Step 1: Find first decreasing element from right
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such element, it's already the largest permutation
        if (i < 0) return -1;

        // Step 2: Find just larger element to the right
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap i and j
        swap(digits, i, j);

        // Step 4: Reverse the part after i
        reverse(digits, i + 1, digits.length - 1);

        // Step 5: Convert to number
        long result = Long.parseLong(new String(digits));

        // Step 6: Check 32-bit integer limit
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
