#https://www.lintcode.com/problem/search-in-rotated-sorted-array/description?_from=ladder&&fromId=1

class Solution:
    """
    @param A: an integer rotated sorted array
    @param target: an integer to be searched
    @return: an integer
    """
    def search(self, A, target):
        if not A:
            return -1
        
        start, end = 0, len(A) - 1 
        while start + 1 < end:
            mid = (start + end) // 2
            if A[mid] >= A[start]:
                if A[start] <= target <= A[mid]:
                    end = mid
                else:
                    start = mid
            else:
                if A[mid] <= target <= A[end]:
                    start = mid
                else:
                    end = mid
                    
        if A[start] == target:
            return start
        if A[end] == target:
            return end
        return -1
            
                
                    
