# 136. Single Number

Difficulty: Easy

https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**
```
Input: [2,2,1]
Output: 1
```

**Example 2:**
```
Input: [4,1,2,1,2]
Output: 4
```


## 使用异或

由于有时间和空间限制，注意题目只有一个元素出现一次，其他都是两次，

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x,y:x ^ y, nums) # reduce方法
```

