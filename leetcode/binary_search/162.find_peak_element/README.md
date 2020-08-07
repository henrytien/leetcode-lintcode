# [162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)

注意：

峰值分析存在三种情况，数组全升序，全降序，^形

由于“遍历会到达第i个元素”本身就说明上一个元素（第i- 1个）不满足 nums[i] > nums[i + 1]这一条件，也就说明 nums[i-1] < nums[i]。

## 分析

参照的是官解的二分+迭代，但是本人在while终止条件设置方面一直晕乎乎的，下面记录debug过程。


首先臆想了最终的“小山峰”应该是[left,mid,right]，所以执行到最后一层循环，right-left=2，如下，最后返回mid
```python
while (right-left>1):
    mid=(left+right)//2
    if nums[mid]<nums[mid+1]: # nums[mid]处于局部升序,left右移
        left=mid
    else: # 若处于降序(依题不会出现平序)，则指针right左移
        right=mid
return mid
```

首先，要想测试终止循环条件只需要采用[1,3,2]，[1,2]，[2,1]这样的特例即可，即最终可能的“小山峰”形态，结果如下：

[1,3,2] 没有进入循环，mid未赋值就return会错误

[1,2]，[2,1] 同样

这里有两个问题，一个是最终不能返回mid，因为最后一层只赋值了left和right，没有赋值mid，应该在其后再加上mid赋值，如下
```python
while (right-left>1):
    mid=(left+right)//2
    if nums[mid]<nums[mid+1]: # nums[mid]处于局部升序,left右移
        left=mid
    else: # 若处于降序(依题不会出现平序)，则指针right左移
        right=mid
    mid=(left+right)//2
return mid
```但这样代码的结构本身就乱了，于是不针对此处改进，把返回改为left或者right即可。此外，原本设想最后一层循环应该是right-left=2，但是对于[1,2]，[2,1]这种情况不适用，于是将终止状态由right-left=2改为right-left=1，如下

```python
while (right-left>=1):
    mid=(left+right)//2
    if nums[mid]<nums[mid+1]: # nums[mid]处于局部升序,left右移
        left=mid
    else: # 若处于降序(依题不会出现平序)，则指针right左移
        right=mid
return right(left)
```

[2,1] 1 0 都没有进入for循环 

而且无论是返回left还是right，[1,2] [2,1]必有一个错误

所以需要在中间移位的时候做一些改动，使用[1,2] [2,1]两个特例代入即可，如下，改动了left=mid+1，

```python
while right>left:
    mid=(left+right)//2
    if nums[mid]<nums[mid+1]: # nums[mid]处于局部升序,left右移
        left=mid+1 
    else: # 若处于降序(依题不会出现平序)，则指针right左移
        right=mid
return left
```
