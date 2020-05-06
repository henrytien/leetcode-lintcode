# https://www.lintcode.com/problem/implement-strstr/description?_from=ladder&&fromId=1
# Time Complexity O(mn)
# Space Complexity O(1)
class Solution:
    """
    @param source: 
    @param target: 
    @return: return the index
    """

    def strStr(self, source, target):
        l1 = len(source)
        l2 = len(target)

        for i in range(l1 - l2 + 1):
            if source[i:i+l2] == target:
                return i
        return -1
