class Solution {
public:
    int missingMultiple(vector<int>& nums, int k) {
        int c=k;
        while(find(nums.begin(),nums.end(),k)!=nums.end()){
            k+=c;
        }
        return k;
    }
};