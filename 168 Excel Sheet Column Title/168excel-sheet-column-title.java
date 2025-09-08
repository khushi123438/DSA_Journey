class Solution {
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int remainder = columnNumber % 26;
            char ch = (char) (remainder + 'A');
            result.append(ch);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int columnNumber = sc.nextInt();

        convertToTitle(columnNumber);
    }
}