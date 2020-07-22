class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0,r=nums.size()-1,m;
        while(l<r)
        {
            m = l + (r-l)/2;
            if(nums[l]>=nums[r])
            {
                if(nums[l]==nums[r]&&nums[l]==nums[m])
                {
                    int res = nums[l];
                    for(;l<r;l++)
                        res = min(res,nums[l]);
                    return res;
                }
                else if(nums[l]<=nums[m])
                    l = m+1;
                else
                    r = m;
            }else
                r = l;
            // cout<<l<<','<<r<<endl;
        }
        return nums[l];
    }
};
