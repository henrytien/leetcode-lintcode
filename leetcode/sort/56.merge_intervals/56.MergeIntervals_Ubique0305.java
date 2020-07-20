// Source : https://leetcode.com/problems/merge-intervals/
// Author : Ubique0305
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to 
 * get new method signature.
 ******************************************************************************************************/

/*
 * 先起点后终点地排序，之后维护一个初始为空的合并区间，不断扩充之
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2) {
            return intervals;
        }

        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> ans = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i = 1; i < n; i++) {
            if(intervals[i][0] <= pre[1]) {
                pre[1] = Math.max(pre[1], intervals[i][1]);
            } else {
                ans.add(pre);
                pre = intervals[i];
            }
        }
        ans.add(pre);

        return ans.toArray(new int[ans.size()][2]);
    }
}
