# https://www.lintcode.com/problem/longest-palindromic-substring/description?_from=ladder&&fromId=1
class Solution:
    """
    @param s: input string
    @return: the longest palindromic substring
    """

    def longestPalindrome(self, s):
        # write your code here
        n = len(s)

        def getLen(l, r):
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            return r - l - 1

        length, start = 0, 0
        for i in range(n):
            cur = max(getLen(i, i), getLen(i, i+1))
            if cur <= length:
                continue
            length = cur
            start = i - (cur - 1) // 2
        return s[start:start+length]
