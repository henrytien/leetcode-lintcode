class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        intervals.sort()
        a, b = intervals[0]
        i = 1
        ans = []
        while(i<len(intervals)):
            c,d = intervals[i]
            if(b>=c):
                b = max(b,d)
            else:
                ans.append([a,b])
                a,b = c,d
            i+=1
        ans.append([a,b])
        return ans 