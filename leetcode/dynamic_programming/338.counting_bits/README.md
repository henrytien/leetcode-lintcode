# 338. Counting Bits

Difficulty: Medium

https://leetcode.com/problems/counting-bits/

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

**Example 1:**
```
Input: 2
Output: [0,1,1]
```

**Example 2:**
```
Input: 5
Output: [0,1,1,2,1,2]
```

**Follow up:**

* It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
* Space complexity should be O(n).
* Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

## pop count

可以看作[位 1 的个数](https://leetcode-cn.com/problems/number-of-1-bits/) 的后续(对一个可以用x &= x - 1)，即对每一个数字计数，然后应用到全部。

### 复杂度

时间：$O(nk)$，对每个整数需要$k$次操作，$k$为其二进制的位数

空间：$O(n)$



## 动态规划+最高有效位

对于一位，即0(1)和1(1)，我们知道其含1的个数ans[0]=0,ans[1]=1，则对于两位的2(10)和3(11)的个数为ans[2]=ans[0]+1，ans[3]=ans[1]+1，这个1就是最高有效位的1，于是状态转移方程为：ans[i+b]=ans[i]+1,b=2^m>x

```python
class Solution:
    '''动态规划+最高有效位
    '''
    def countBits(self, num: int) -> List[int]:
        ans = [0]*(num+1)
        # generate ans for [0,b)
        i = 0
        b = 1
        ans[0] = 0
        while b <= num:
            # generate [b,2b) or [b,num] for [0,b] 
            while i<b and i+b<=num:
                ans[i+b]= ans[i]+1
                i+=1
            i=0 # reset i
            b <<= 1
        return ans
```



## 动态规划+最低有效位

```python
class Solution:
    '''动态规划+最低设置位
    '''
    def countBits(self, num: int) -> List[int]:
        ans = [0]*(num+1)
        for i in range(num+1):
            ans[i]=ans[i>>1]+(i&1) # i&1 即 i mod 2
        return ans
```



## 动态规划+最后设置位

```python
class Solution:
    '''动态规划+最后设置位
    '''
    def countBits(self, num: int) -> List[int]:
        ans = [0]*(num+1)
        for i in range(1,num+1):
            ans[i] = ans[i & (i - 1)] + 1 # i & (i - 1)得到i最后为1的位
        return ans
```

