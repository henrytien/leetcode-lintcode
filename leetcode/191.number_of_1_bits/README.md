# [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)

位1的个数也称为[汉明重量](https://baike.baidu.com/item/汉明重量)

## 解法一

直接定义一个mask每次左移并与n比对，如果不为1说明有一个1，由于n是无符号整型，所以总共32位

```python
class Solution:
    def hammingWeight(self, n: int) -> int:
        bits = 0
        mask = 1
        for i in range(32):
            if n & mask != 0:
                bits+=1
            mask <<= 1
        return bits
```

## 解法二

利用n &= (n - 1)会把n的最后一个1变成0，其他不变

```python
class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n:
            n &= (n - 1)
            ans += 1
        return ans
```

