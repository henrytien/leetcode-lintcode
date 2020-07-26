# Source : https://leetcode.com/problems/count-of-smaller-numbers-after-self/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
# Author : yhwhu
# Date   : 2020-07-26

##################################################################################################### 
#
# You are given an integer array nums and you have to return a new counts array. The counts array has 
# the property where counts[i] is the number of smaller elements to the right of nums[i].
# 
# Example:
# 
# Input: [5,2,6,1]
# Output: [2,1,1,0] 
# Explanation:
# To the right of 5 there are 2 smaller elements (2 and 1).
# To the right of 2 there is only 1 smaller element (1).
# To the right of 6 there is 1 smaller element (1).
# To the right of 1 there is 0 smaller element.
#####################################################################################################

class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        if not nums: return []

        sorted_nums = []
        ans = []
        for n in nums[::-1]:
            index = bisect.bisect_left(sorted_nums, n)
            bisect.insort(sorted_nums, n)
            ans.append(index)
        return ans[::-1]

