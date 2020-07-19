# [137. 只出现一次的数字 II](https://leetcode-cn.com/problems/single-number-ii/)

<img src="assets/image-20200715141347820.png" alt="image-20200715141347820" style="zoom:50%;" />

```python
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        seen_once = seen_twice = 0
        for num in nums:
            seen_once = ~seen_twice & (seen_once ^ num)
            seen_twice = ~seen_once & (seen_twice ^ num)
        return seen_once
```

