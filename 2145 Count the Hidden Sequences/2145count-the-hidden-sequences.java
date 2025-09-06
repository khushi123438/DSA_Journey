class Solution {
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long minPrefix = 0, maxPrefix = 0;

        for (int diff : differences) {
            prefix += diff;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
        }

        long left = lower - minPrefix;
        long right = upper - maxPrefix;

        return (int)Math.max(0, right - left + 1);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int n = sc.nextInt();
        int differences[] = new int[n];

        for(int i=0;i<n;i++){
            differences[i]= sc.nextInt();
        }

        numberOfArrays(differences,lower,upper);

    }
}
