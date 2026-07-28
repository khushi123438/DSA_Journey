class Solution {
    public String smallestPalindrome(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (i + 1 < n && arr[i] == arr[i + 1]) {
                left.append(arr[i]);
                i++; // pair skip
            } else {
                mid.append(arr[i]);
            }
        }

        StringBuilder right = new StringBuilder(left);
        right.reverse();

        return left.toString() + mid.toString() + right.toString();
    }
}