# [29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

## 解法一

将dividend依次减掉divisor，总共减掉的次数就是结果即商。

比如10/3，每次10-3-3-3=1，总共减了3次，对应的结果则为1+1+1=3。

对于$truncate(ividend/divisor)=n$，算法复杂度为$O(n)$

## 解法二

### 思想
上面解法对于dividend很大divisor很小的地方一定会超时。跟```50.pow-x-n```一样，需要利用中间量。一个简单的思路就是将```3*2^0```加上自身(即翻倍)就是6，同时记下6对应3的2倍，再将```6=3*2^1```翻倍为12发现大于10，终止翻倍。这个过程中产生了3和6两个中间量，先将10减掉最大的6，计数为然后减掉3，则在10-6-3的同时对应的结果为2+1=3。
### 复杂度
这个过程采用了二分法的思路优化了减掉了次数，对于$truncate(ividend/divisor)=n$，算法复杂度为$O(log n)$

### 实现方式

二进制移位+递归，



```python
class Solution:
    def divide(self, dividend, divisor):
        # 先讲a,b都转为正数
        i, a, b = 0, abs(dividend), abs(divisor)
        if a == 0 or a < b:
            return 0
        
        while b <= a:
            b = b << 1
            i = i + 1
        
        #! 由于a,b必须在[−2^31,  2^31 − 1] 范围内，这里当a为最大值时，b会超出，所以本方法只适用于python
        else:
            res = (1 << (i - 1)) + self.divide(a - (b >> 1), abs(divisor))
            if (dividend ^ divisor) < 0:
                res = -res
            return min(res, (1 << 31) - 1)
```

由于a,b必须在[−2^31,  2^31 − 1] 范围内，这里当a为最大值时，b会超出，所以上面方法不是通用，以下改进版：

```python
class Solution:
    ''' dividend = divisor^(2^0)+divisor^(2^1)+divisor^(2^1)+...
    '''
    def divide(self, dividend, divisor):
        if dividend==0: return 0 # 这个加不加无所谓，题目给出除数不为0
        sign = 1 if dividend * divisor >= 0 else -1 # 正负判断
        dividend, divisor = abs(dividend), abs(divisor)
        NEG_INF, POS_INF = (1 << 31) * (-1), (1 << 31) - 1
        ans = 0
        while dividend >= divisor:
            bit = 0
            while True:
                if (dividend>>bit) < divisor:
                    bit -= 1
                    break
                bit += 1
            ans += 1<<bit
            dividend = dividend - (1<<bit) * divisor
        ans = sign * int(ans)
        if ans < NEG_INF or ans > POS_INF:
            return POS_INF
        else:
            return ans
```

