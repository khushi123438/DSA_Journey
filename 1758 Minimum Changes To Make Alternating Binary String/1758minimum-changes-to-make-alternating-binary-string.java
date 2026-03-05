class Solution {
    public int minOperations(String s) {
        int zero = 0;
        int one = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            char ex0 = (i % 2 == 0) ? '0' : '1';
            char ex1 = (i % 2 == 0) ? '1' : '0';
            
            if(ch!=ex0)
            zero++;

            if(ch!=ex1)
            one++;



        }

        return Math.min(one,zero);
    }
}