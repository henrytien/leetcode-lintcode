# [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)

在[153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)的基础上，加一个```nums[mid] == nums[right]```的判断。时间复杂度上，当数组中包含相同元素时(```nums[mid] == nums[right]```)，需要逐个遍历元素，复杂度为O(N)