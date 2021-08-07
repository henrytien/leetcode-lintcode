// Source : https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining 
 * a profit of profit[i].
 * 
 * You're given the startTime , endTime and profit arrays, you need to output the maximum profit you 
 * can take such that there are no 2 jobs in the subset with overlapping time range.
 * 
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 * 
 * Example 1:
 * 
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job. 
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * 
 * Example 2:
 * 
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job. 
 * Profit obtained 150 = 20 + 70 + 60.
 * 
 * Example 3:
 * 
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 * 
 * Constraints:
 * 
 * 	1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
 * 	1 <= startTime[i] < endTime[i] <= 10^9
 * 	1 <= profit[i] <= 10^4
 ******************************************************************************************************/

class Solution {
    // O(NlogN)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length == 0) {
            return 0;
        }
        
        int n = startTime.length;
        
        // sort by end time
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        for (var i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
            endTime[i] = jobs[i][1];
            profit[i] = jobs[i][2];
        }
        
        var dp = new int[n];
        dp[0] = profit[0];
        
        for (var i = 1; i < n; i++) {
            // binarySearch(Object[] a, int fromIndex, int toIndex, Object key)

            // a：要搜索的数组
            // fromIndex：指定范围的开始处索引（包含）
            // toIndex：指定范围的结束处索引（不包含）
            // key：要搜索的值

            // 如果要搜索的元素key在指定的范围内，则返回搜索值的索引；否则返回 -(插入点 + 1)。
            
            var index = Arrays.binarySearch(endTime, 0, i, startTime[i]);
            if (index == -1) { // startTime[i] 比所有的 endTime 都小，待插入位置为 0，返回 -1
                dp[i] = Math.max(dp[i - 1], profit[i]);
            } else if (index < 0) { // startTime[i] 不在 endTime 中，前一个值：dp[-(index + 1) - 1]
                dp[i] = Math.max(dp[i - 1], dp[-index - 2] + profit[i]);
            } else { // startTime[i] 在 endTime 中
                dp[i] = Math.max(dp[i - 1], dp[index] + profit[i]);
            }
            
            // System.out.println(dp[i]);
        }
        
        return dp[n - 1];
    }
    
    public int jobScheduling_oNxN(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length == 0) {
            return 0;
        }
        
        int n = startTime.length;
        
        // sort by end time
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        for (var i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
            endTime[i] = jobs[i][1];
            profit[i] = jobs[i][2];
        }
        
        // System.out.println(Arrays.toString(startTime));
        // System.out.println(Arrays.toString(endTime));
        // System.out.println(Arrays.toString(profit));
        
        var dp = new int[n];
        dp[0] = profit[0];
        
        for (var i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], profit[i]);
            
            for (var j = i - 1; j >= 0; j--) {
                if (endTime[j] <= startTime[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + profit[i]);
                    break;
                }
            }
            
            // System.out.println(dp[i]);
        }
        
        return dp[n - 1];
    }
    
    // TLE: sort by startTime, we have to use a max variable and compare all the dp array
    public int jobScheduling_startTime(int[] startTime, int[] endTime, int[] profit) {
        if (startTime.length == 0) {
            return 0;
        }
        
        int n = startTime.length;
        
        // sort by end time
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        for (var i = 0; i < n; i++) {
            startTime[i] = jobs[i][0];
            endTime[i] = jobs[i][1];
            profit[i] = jobs[i][2];
        }
        
        var dp = new int[n];
        dp[0] = profit[0];
        
        var max = dp[0];
        for (var i = 1; i < n; i++) {
            dp[i] = profit[i]; // 不能考虑 dp[i - 1] 了，因为用了 startTime 排序，dp[i - 1] 可能还没结束
            
            for (var j = i - 1; j >= 0; j--) {
                if (endTime[j] <= startTime[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + profit[i]);
                    // 这里也不能 break 了，因为所有的结果都没有和 dp[i - 1] 比较，
                    // 只有把前面的都比较了，才能找出最大的
                    // break;  
                }
            }
            
            max = Math.max(dp[i], max);
            System.out.println(dp[i]);
        }
        
        return max;
    }
}