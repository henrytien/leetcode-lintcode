# 56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

**Example 1:**

```
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

## Ideas

Sort and Merge.

If we sort the array of array by the value of the first element and then the second, then it's easier to find out the overlap. All the intervals that can be merged should occur contiguously. If the current interval overlaps with the previous one, then merge them by updating the end of the previous interval's end. If not, add the current interval and mark it as the previous interval.

## Highlights

**Array of Array Sort**

**Use the previous interval to check the overlap**

* When two intervals overlap, change the end of the previous interval to be the larger one.

**Change a List of Array to an Array of Array**

## Code

```java
# Source : https://leetcode.com/problems/merge-intervals/
# Author: Eve
# Date: 2020-07-18

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] previous = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(last);
        for (int[] interval: intervals) {
            if (interval[0] <= previous[1]) {
                previous[1] = Math.max(interval[1], previous[1]);
            } else {
                res.add(interval);
                previous = interval;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
```

