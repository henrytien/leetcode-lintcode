class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        opt = float("inf")
        for i in range(len(nums)):
            # Fix one integer
            fixed = nums[i]
            newTarget = target-fixed
            l,r = i+1, len(nums)-1
            while(l<r):
                now = nums[l]+nums[r]
                # If sum of other two integer<newTarget,
                # meaning need to make left integer bigger.
                if now<newTarget:
                    l = l+1
                elif now==newTarget:
                    return target
                else:
                    r = r-1
                if(abs(opt-target)>abs(now+fixed-target)):
                    opt = now+fixed
        return opt