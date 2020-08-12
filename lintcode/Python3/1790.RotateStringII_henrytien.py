# https://www.lintcode.com/problem/rotate-string-ii/description?_from=ladder&&fromId=1
class Solution:
    """
    @param str: A String
    @param left: a left offset
    @param right: a right offset
    @return: return a rotate string
    """

    def RotateString2(self, str, left, right):
        offset = (left - right) % len(str)
        return str[offset:] + str[:offset]
