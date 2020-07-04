#https://www.lintcode.com/problem/wildcard-matching/description?_from=ladder&&fromId=1

class Solution:
    """
    @param s: A string 
    @param p: A string includes "?" and "*"
    @return: is Match?
    """
    def isMatch(self, s, p):
        # write your code here
        memo = {}
        return self.dfs(s, 0, p, 0, memo)
        
    def dfs(self, s, sIndex, p, pIndex, memo):
        if pIndex == len(p):
            return sIndex == len(s)
        if sIndex == len(s):
            return self.isAllStar(p,pIndex)
        if (sIndex,pIndex) in memo:
            return memo[sIndex,pIndex]
        
        match = False
        if p[pIndex] == '*':
            match = self.dfs(s, sIndex+1, p, pIndex, memo) or self.dfs(s, sIndex, p, pIndex + 1,memo)
        else:
            match = (s[sIndex] == p[pIndex] or p[pIndex] == '?') and self.dfs(s, sIndex + 1, p, pIndex + 1, memo)
        memo[sIndex,pIndex] = match
        return match
            
        
    def isAllStar(self, p, index):
        newStr = p[index:]
        for c in newStr:
            if c != '*':
                return False
        return True
            
        
        
