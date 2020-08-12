# https://www.lintcode.com/problem/k-closest-points/description?_from=ladder&&fromId=1

"""
Definition for a point.
class Point:
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b
"""
import heapq
class Solution:
    """
    @param points: a list of points
    @param origin: a point
    @param k: An integer
    @return: the k closest points
    """
    def kClosest(self, points, origin, k):
        self.heap = []
        for point in points:
            dist = self.get_distance(point,origin)
            heapq.heappush(self.heap,(dist,point.x,point.y))
            
        result = []
        for _ in range(k):
            _,x,y = heapq.heappop(self.heap)
            result.append(Point(x,y))
        return result
            
    
    def get_distance(self, a, b):
        return (a.x - b.x)**2 + (a.y - b.y)**2