# [349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)

本题二分的复杂度并不低。

## 暴力解法
设len(nums1)=n, len(nums2)=m，依次检查nums1中的元素是否在nums2中，由于是数组，每次检查需要$O(m)$时间，所以总时间复杂度为$O(n*m)$
## 使用Set

由于集合操作的平均时间复杂度为$O(1)$，可以将两个数组转为Set，然后迭代较小的集合检查是否存在在较大集合中。平均情况下，这种方法的时间复杂度为$O(n+m)$，空间复杂度为$O(n+m)$。如下：

```python
class Solution:
    def set_intersection(self, set1, set2):
        return [x for x in set1 if x in set2]
        
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """  
        set1 = set(nums1)
        set2 = set(nums2)
        
        if len(set1) < len(set2):
            return self.set_intersection(set1, set2)
        else:
            return self.set_intersection(set2, set1)
```
还可以使用内置函数：
```python
class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """  
        set1 = set(nums1)
        set2 = set(nums2)
        return list(set2 & set1)
```

## 二分查找

[参考](https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/duo-chong-jie-fa-jie-jue-349-liang-ge-shu-zu-de-ji/)
