# https://www.lintcode.com/problem/longest-palindrome/description?_from=ladder&&fromId=1
# Idea:
# Greedy + Counting
# T O(n)
# S O(128)


class Solution:
    """
    @param s: a string which consists of lowercase or uppercase letters
    @return: the length of the longest palindromes that can be built
    """

    def longestPalindrome(self, s):
        freqs = [0]*128
        for c in s:
            freqs[ord(c)] += 1

        ans, odd = 0, 0
        for freq in freqs:
            ans += freq & (~1)
            odd |= freq & (1)

        return ans + odd
