#https://www.lintcode.com/problem/single-number-iii/description

class Solution:
    """
    @param A: An integer array
    @return: An integer array
    """
    def singleNumberIII(self, A):
        if not A:
            return None
        
        dict = {}
        for num in A:
            if num not in dict:
                dict[num] = 1 
            else:
                if dict[num] == 1:
                    del(dict[num])
        
        return list(dict)
