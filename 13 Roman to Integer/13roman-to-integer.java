class Solution {
    public static int romanToInt(String s) {
       HashMap<Character,Integer> mp = new HashMap<>();

       mp.put('I',1);
       mp.put('V',5);
       mp.put('X',10);
       mp.put('L',50);
       mp.put('C',100);
       mp.put('D',500);
       mp.put('M',1000);

       int total = 0;
       int n= s.length();

       for(int i=0;i<n;i++){
         int value=mp.get(s.charAt(i));

         if(i<n-1 && value<mp.get(s.charAt(i+1)))
         total-=value;

         else
         total+=value;
       }
       return total;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase(); 

        int result = romanToInt(s);
        System.out.println(result);
    }
}