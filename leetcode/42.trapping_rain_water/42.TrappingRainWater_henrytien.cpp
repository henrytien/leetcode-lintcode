// Source : https://leetcode.com/problems/trapping-rain-water/
// Author : henrytien
// Date   : 2022-02-02

/*****************************************************************************************************
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * 	n == height.length
 * 	1 <= n <= 2 * 104
 * 	0 <= height[i] <= 105
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    int trap(vector<int> &height)
    {

        if (height.size() == 0)
        {
            return 0;
        }
        int res = 0;
        int left = 0, right = height.size() - 1;
        int max_left = 0, max_right = 0;

        while (left <= right)
        {
            if (height[left] <= height[right])
            {
                if (height[left] > max_left)
                {
                    max_left = height[left];
                }
                else
                {
                    res += max_left - height[left];
                }
                left++;
            }
            else
            {
                if (height[right] > max_right)
                {
                    max_right = height[right];
                }
                else
                {
                    res += max_right - height[right];
                }
                right--;
            }
        }
        return res;
    }
};

int main()
{

    vector<int> height{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    cout << Solution().trap(height);
    return 0;
}
