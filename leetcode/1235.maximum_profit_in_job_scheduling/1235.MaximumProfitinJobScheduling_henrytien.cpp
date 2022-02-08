// Source : https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// Author : henrytien
// Date   : 2022-02-08

/*****************************************************************************************************
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining
 * a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such
 * that there are no two jobs in the subset with overlapping time range.
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
 * 	1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 	1 <= startTime[i] < endTime[i] <= 109
 * 	1 <= profit[i] <= 104
 ******************************************************************************************************/

#include "../inc/ac.h"

// dp bottom-up

class Solution1
{
public:
    // Maximum number of jobs are 50000
    int memo[50001];

    int jobScheduling(vector<int> &startTime, vector<int> &endTime, vector<int> &profit)
    {

        int n = startTime.size();
        // Storing job's details into one list
        // This will hep in sorting the jobs while maintaining the other paramaters
        vector<vector<int>> jobs;
        for (int i = 0; i < n; i++)
        {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }

        sort(jobs.begin(), jobs.end());

        // Binary search will be used in startTime so store it as separate list

        for (int i = 0; i < n; i++)
        {
            startTime[i] = jobs[i][0];
        }

        return find_max_profit(startTime, jobs);
    }

private:
    int find_max_profit(vector<int> &startTime, vector<vector<int>> &jobs)
    {
        int len = startTime.size();

        for (int i = len - 1; i >= 0; i--)
        {
            // It's the profit made by scheduling the current job
            int curr_profit = 0;

            // Next index is the index of no-conflicting job
            // This step is similar to the binary search
            // lower_bound will return the iterator to teh first element which is
            // equal to or greater than the element at 'jobs[i][1]`
            int next_index = lower_bound(startTime.begin(), startTime.end(), jobs[i][1]) - startTime.begin();
            if (next_index != len)
            {
                curr_profit = jobs[i][2] + memo[next_index];
            }
            else
            {
                curr_profit = jobs[i][2];
            }

            // Storing the maximum profit we can achieve by scheduling
            // non-conflicting jobs from index i to the end of array
            if (i == len - 1)
            {
                memo[i] = curr_profit;
            }
            else
            {
                memo[i] = max(curr_profit, memo[i + 1]);
            }
        }

        return memo[0];
    }
};
// Approach 2: Sorting + Priority Queue
class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.size(); i++)
        {
            jobs.push_back({startTime[i],endTime[i],profit[i]});
        }
        sort(jobs.begin(),jobs.end());
        return find_max_profit(jobs);
        
    }
    private:
    int find_max_profit(vector<vector<int>> &jobs) {
        int len = jobs.size(), max_profit = 0;
        priority_queue<vector<int>,vector<vector<int>> ,greater<vector<int>>> pq;

        for (int i = 0; i < len; i++)
        {
            int start = jobs[i][0], end = jobs[i][1], profit =jobs[i][2];
            // Keep poping while the head is not empty and 
            // Jobs are not conflicting
            // Update the value of max_profit.
            while (!pq.empty() && start >= pq.top()[0])
            {
                max_profit = max(max_profit,pq.top()[1]);
                pq.pop();
            }

            // Push the job with combind profit
            // If not non-conflicting job is present max_profit will be 0
            pq.push({end,profit+max_profit});
        }
        
        // Update the value of max_profit by campring with profit of jobs that exits in heap
        while (pq.empty() == 0) {
            max_profit = max(max_profit,pq.top()[1]);
            pq.pop();
        }
        return max_profit;
    }
};

int main()
{

    vector<int> start_time{1, 2, 3, 4, 6}, end_time{3, 5, 10, 6, 9}, profit{20, 20, 100, 70, 60};
    cout << Solution().jobScheduling(start_time, end_time, profit) << "\n";
    return 0;
}
