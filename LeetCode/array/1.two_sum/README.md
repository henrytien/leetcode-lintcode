## 暴力法

两层嵌套遍历

## 两遍哈希表

用空间换取时间。因为哈希表的查找速度为$O(1)$，所以先遍历数组存成哈希表。然后再次遍历$num[i]$，并查找$target-num[i]$是否存在于表中

### 复杂度

时间：

空间：

### 代码

python中可以用字典模拟哈希表。

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        for ind,num in enumerate(nums):
            hashmap[num] = ind
        for i,num in enumerate(nums):
            j = hashmap.get(target - num)
            if j is not None and i!=j:
                return [i,j]
```

## 一遍哈希表

依次遍历数组元素$num[i]$存为哈希表，同时检查表中已有的元素是否存在$target-num[i]$，如果存在就返回结果。

> 此方法会有漏解的争议，但实际上没有

### 代码

```python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''一遍哈希表
        '''
        hashmap={}
        for i,num in enumerate(nums):
            if hashmap.get(target - num) is not None:
                return [hashmap.get(target - num),i]
            hashmap[num] = i #这句不能放在if语句之前，解决list中有重复值或target-num=num的情况
```

