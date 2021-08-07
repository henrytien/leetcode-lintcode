# [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

## 中心扩展法

回文中心的两侧互为镜像，因此回文可以从它的中心依次展开。

对于长度为$n$的字符串，有且仅有$ 2n - 1$ 个这样的中心。其中回文子串长度为偶数时比如“abba” ，它的中心包含两个字母“bb”，对应的中心有$n-1$个。长度为奇数的回文子串比如"aba"，中心只包含一个字母，对应的中心有$n$个。

```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if (s == "" or len(s) < 1): return ""
        start, end = 0, 0
        for i in range(len(s)):
            len1=self.expandAroundCenter(s, i, i);
            len2 = self.expandAroundCenter(s, i, i + 1);
            len_max=max(len1,len2)
            if (len_max>end-start):
                start = i - int((len_max - 1) / 2);
                end = i + int(len_max / 2);
        return s[start:end + 1]
        
    def expandAroundCenter(self,s,left,right):
        L ,R= left, right
        while (L >= 0 and R < len(s) and s[L] == s[R]):
            L-=1
            R+=1
        return R - L - 1
```

### 复杂度分析

* 时间复杂度：$O(n^2)$

  由于围绕中心来扩展回文会耗去 $O(n)$ 的时间，所以总的复杂度为$ O(n^2)$。

* 空间复杂度：$O(1)$

### 中心扩展法改进

中心扩展法，n 个字符，2n - 1 个中心，但是我看着，好像还是最大 n 个中心就可以了？

因为回文肯定是 aba, abba, abbba 这样的形式，可以看出，扩展中心连续相同的字符可以不论次数奇偶，视为同一个中心，然后直接忽略相同的中心字符，在不相同的字符处再开始判断两端的其它字符是否相同。

因此一次扩展可以以连续相同的字符为同一个中心进行，这样每个字符都不相同的话，有 n 个扩展中心；如果有连续相同字符出现，则扩展中心小于 n 个。

```python
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if (s == "" or len(s) < 1): return ""
        start, end = 0, 0
        i=0
        while i<len(s):
            repeat_len=1
            while (i+repeat_len)<=len(s)-1 :
                if s[i]!=s[i+repeat_len]:
                    break
                repeat_len+=1
            len_max=self.expandAroundCenter(s, i, i + repeat_len-1);
            if (len_max>end-start+1):
                start = i - int((len_max-repeat_len) / 2)
                end = i+repeat_len-1 + int((len_max-repeat_len) / 2)
            i=i+repeat_len
        return s[start:end+1]
        
    def expandAroundCenter(self,s,left,right):
        L ,R= left, right
        while (L >= 0 and R < len(s) and s[L] == s[R]):
            L-=1
            R+=1
        return R - L - 1
```

## Manacher 算法

略