class Solution {
public:
    int countPartitions(vector<int>& nums, int k) {
        const int MOD = 1000000007;
        int n = nums.size();
        vector<int> dp(n+1,0), pref(n+1,0);
        dp[0]=1; 
        pref[0]=1;

        deque<int> minq, maxq;
        int left=0;

        for(int r=0;r<n;r++){
            while(!maxq.empty() && nums[maxq.back()]<=nums[r]) maxq.pop_back();
            maxq.push_back(r);

            while(!minq.empty() && nums[minq.back()]>=nums[r]) minq.pop_back();
            minq.push_back(r);

            while(nums[maxq.front()] - nums[minq.front()] > k){
                if(maxq.front()==left) maxq.pop_front();
                if(minq.front()==left) minq.pop_front();
                left++;
            }

            long long ways = pref[r];
            if(left>0) ways = (ways - pref[left-1] + MOD) % MOD;

            dp[r+1] = ways;
            pref[r+1] = (pref[r] + dp[r+1]) % MOD;
        }
        return dp[n];
    }
};

