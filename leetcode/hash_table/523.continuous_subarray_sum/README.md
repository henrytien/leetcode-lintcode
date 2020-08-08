# [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)

给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

> 输入: [23,2,4,6,7], k = 6
> 输出: True
> 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。

示例 2:

> 输入: [23,2,6,4,7], k = 6
> 输出: True
> 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。

说明:

数组的长度不会超过10,000。
你可以认为所有数字总和在 32 位有符号整数范围内。

## 暴力法

​		暴力方法是很显然的。我们考虑所有长度大于等于 2 的子数组，我们将子数组遍历一遍求和，并判断和是否是给定整数 k 的倍数。

## 优化的暴力

​		使用sum数组保存数组的累积和，比如sum[i]表示前i项和，那么第i个数到第j个数之间的连续和为sum[j]-sum[i]+nums[i]，判断它是否能够整除n就可，前提k不等于0。

```python
class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        sum=[]
        sum.append(nums[0])
        print(len(nums))
        for i in range(1,len(nums)):
            sum.append(sum[i-1]+nums[i])

        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                summ=sum[j]-sum[i]+nums[i]
                if summ==k or (k!=0 and summ%k==0):
                    return True

        return False
```



## 哈希表法



有的也把该方法称为动态规划，不多bb。首先需要用到前缀和与取余之间的关系：

(preSum[i]−preSum[j]) mod \ k=0 ⟺ preSum[i] mod \ k== preSum[j] mod \ k
(preSum[i]−preSum[j])mod k=0⟺preSum[i]mod k==preSum[j]mod k

其中preSum[i]−preSum[j]preSum[i]−preSum[j]可以表示为题目要求的连续子数组的和，i-j>1i−j>1(因为子数组最低长度为2)。也就是问题可以转换为只要前缀和preSum[i]和preSum[j]对k的余数相等即可，其中i-j>1i−j>1，即遍历数组求出前缀和并检查当前的前缀和取余与之前的是否相同，这就可以用哈希表法了，也是核心思想。

另外有

(preSum[i] mod \ k + nums[i+1]) mod \ k = (preSum[i]+nums[i+1]) mod \ k = preSum[i+1] mod\ k
(preSum[i]mod k+nums[i+1])mod k=(preSum[i]+nums[i+1])mod k=preSum[i+1]mod k

这么一个“潜规则”似乎没有提到，有了该等式方便循环，具体见程序。

但是会有几个问题，因为前缀和之差preSum[i]−preSum[j]是无法包含nums[0]的，比如preSum[1]−preSum[0]=nums[1]，所以需要加一个辅助项preSum[-1]=0.

然后以上方法都基于取余的运算，但是k=0的时候无法取余，所以k=0的时候可以单独考虑，此时只需要遍历数组，如果连续相邻的元素都为0就可以返回True。

代码如下:

```python
class Solution:
    '''哈希表法
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums)<2 : return False
        ## k == 0时另外判断
        if k == 0:
            for i in range(len(nums)-1):
                if nums[i]== 0 and nums[i+1] == 0:
                    return True
            return False
        preSum = 0
        dict = {0:-1} # 针对[23,2,6,4,7], k = 6等全数组和才是k的倍数的情况需要加一个辅助空间
        for i in range(len(nums)):
            preSum += nums[i]
            preSum %= k
            if dict.get(preSum) is not None:
                pre_idx = dict.get(preSum)
                if i - pre_idx > 1:
                    return True
            else:
                dict[preSum] = i  
        return False
```

使用python的setdefault的方法可以简化为：

```python
class Solution:
    '''哈希表法
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums)<2 : return False
        ## k == 0时另外判断
        if k == 0:
            for i in range(len(nums)-1):
                if nums[i]== 0 and nums[i+1] == 0:
                    return True
            return False
        preSum = 0
        dict = {0:-1} # 针对[23,2,6,4,7], k = 6等全数组和才是k的倍数的情况需要加一个辅助空间
        for i in range(len(nums)):
            preSum += nums[i]
            preSum %= k
            pre_idx = dict.setdefault(preSum,i)
            if i - pre_idx > 1:
                    return True
        return False
```