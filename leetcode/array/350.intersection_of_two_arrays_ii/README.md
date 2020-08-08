# [350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)

本题是349.两个数组的交集的变体，题目是输出两个数组的交集，且交集中的元素可重复。

本题虽然打着二分的标签，但是实际上用哈希表更适合。

注意[349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)使用的是set，数学意义上表示无序和无重复元素的集合，与dict相比只有key没有value，也可以算是一种哈希表。

## 哈希表法

```python
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            tmp = nums1
            nums1 = nums2
            nums2 = tmp
        num1_map = {}
        for num in nums1:
            num1_map[num] = num1_map.get(num, 0) + 1
        res = []
        for num in nums2:
            if num1_map.get(num, 0) > 0:
                res.append(num)
                num1_map[num] -= 1
        return res
```

