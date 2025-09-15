class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n= nums.length;
           int cd1=0, cd2=1;
           int c1=0, c2=0;

           for(int num:nums){
              if(num==cd1)
              c1++;

              else if(num==cd2)
              c2++;

              else if(c1==0){
                cd1=num;
                c1=1;
              }

              else if(c2==0){
                cd2=num;
                c2=1;
              }

              else{
                c1--;
                c2--;
              }
           }

           c1=0;c2=0;

           for(int num:nums){
            if(num==cd1)
            c1++;

            if(num==cd2)
            c2++;
           } 


           List<Integer> res = new ArrayList<>();

           if(c1>n/3)
           res.add(cd1);

           if(c2>n/3)
           res.add(cd2);


           return res;              
    };
}