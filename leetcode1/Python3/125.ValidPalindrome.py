# https://leetcode.com/problems/valid-palindrome/submissions/
# Tow pointer
# Space Complexity O(1)
# Time Complexity O(n)


class Solution:
    def isPalindrome(self, s: str) -> bool:
        l, r = 0, len(s) - 1
        while l < r:
            while l < r and not s[l].isalnum():
                l += 1
            while l < r and not s[r].isalnum():
                r -= 1

            if s[l].lower() != s[r].lower():
                return False
            l = l+1
            r = r-1
        return True
