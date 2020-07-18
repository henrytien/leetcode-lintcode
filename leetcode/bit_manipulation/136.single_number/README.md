# [136. 只出现一次的数字](https://leetcode-cn.com/problems/single-number/)

## 使用异或

由于有时间和空间限制，注意题目只有一个元素出现一次，其他都是两次，

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x,y:x ^ y, nums) # reduce方法
```

