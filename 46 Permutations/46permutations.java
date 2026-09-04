class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result=new ArrayList();
        permutation(result,nums,new ArrayList(),used);

        return result;
    }
    static void permutation(List<List<Integer>> result, int[] nums,List<Integer> p, boolean[] used){
        if(nums.length==p.size()){
            result.add(new ArrayList<>(p));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            p.add(nums[i]);
            permutation(result,nums,p,used);
            p.remove(p.size()-1);
            used[i]=false;
        }
    }
}