// Source : https://leetcode.com/problems/merge-intervals/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to 
 * get new method signature.
 * 
 * Constraints:
 * 
 * 	intervals[i][0] <= intervals[i][1]
 ******************************************************************************************************/

class Solution {
    public int[][] merge(int[][] intervals) {
        var result = new ArrayList<int[]>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[result.size()][]);
        }
        
        var queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        for (var i = 0; i < intervals.length; i++) {
            queue.offer(intervals[i]);
        }
        
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            
            if (!queue.isEmpty() && cur[1] >= queue.peek()[0]) {
                var next = queue.peek();
                next[0] = cur[0];
                next[1] = Math.max(cur[1], next[1]);
            } else {
                result.add(cur);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}