# Source : https://leetcode.com/problems/decode-string
# Author : zheyuuu
# Date   : 2020-08-05

##################################################################################################### 
#
# Given an encoded string, return its decoded string.
# 
# The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
# being repeated exactly k times. Note that k is guaranteed to be a positive integer.
# 
# You may assume that the input string is always valid; No extra white spaces, square brackets are 
# well-formed, etc.
# 
# Furthermore, you may assume that the original data does not contain any digits and that digits are 
# only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
# 
# Example 1:
# Input: s = "3[a]2[bc]"
# Output: "aaabcbc"
# Example 2:
# Input: s = "3[a2[c]]"
# Output: "accaccacc"
# Example 3:
# Input: s = "2[abc]3[cd]ef"
# Output: "abcabccdcdcdef"
# Example 4:
# Input: s = "abc3[cd]xyz"
# Output: "abccdcdcdxyz"
#####################################################################################################
class Solution:
    # My solution
    def decodeString(self,s):
        ans, i = self.dfs(s, 0)
        return ans
    def dfs(self, s, i):
        cur = ""
        while(i<len(s)):
            while(i<len(s) and ("a"<=s[i]<="z" or "A"<=s[i]<="Z")):
                cur = cur + s[i]
                i+=1
            num = "0"
            while(i<len(s) and "0"<=s[i]<="9"):
                num += s[i]
                i+=1
            num = int(num)
            if num!=0:
                tmp, j = self.dfs(s, i+1)
                cur += num*tmp
                i = j
            if i<len(s) and s[i] == "]":
                return cur, i+1
        return cur,i
    
    # Refer to others
    def decodeString(self, s):
        def dfs(s, pos):
            word = ""
            num = "0"
            while(pos<len(s)):
                if s[pos]=="]":
                    return word, pos+1
                elif s[pos] == "[":
                    tmp, newPos = dfs(s, pos+1)
                    word += tmp*int(num)
                    pos = newPos
                    num = "0"
                elif "0"<=s[pos]<="9":
                    num += s[pos]
                    pos += 1
                else:
                    word += s[pos]
                    pos += 1
            return word, pos 
        
        ans, _ = dfs(s, 0)
        return ans


# if __name__ == "__main__":
#     Solution().decodeString("3[a2[c]]")
#     Solution().decodeString("3[a]2[bc]")
#     Solution().decodeString("3[a]2[b4[F]c]")




