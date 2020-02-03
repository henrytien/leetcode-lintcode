//https://www.lintcode.com/problem/partition-array/description
/*two pointer*/
class Solution
{
public:
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    int partitionArray(vector<int> &nums, int k)
    {
        int size = nums.size();
        if (size == 0)
            return 0;
        int start = 0, end = size - 1;
        while (start <= end)
        {
            if (nums[start] < k)
            {
                start++;
                continue;
            }
            if (nums[end] >= k)
            {
                end--;
                continue;
            }
            swap(nums[start++], nums[end--]);
        }
        return start;
    }
};

class Solution
{
public:
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    int partitionArray(vector<int> &nums, int k)
    {
        int len = nums.size();
        if (len == 0)
        {
            return 0;
        }

        sort(nums.begin(), nums.end());
        for (int i = 0; i < len; i++)
        {
            if (nums[i] == k)
                return i;
        }

        if (k > nums[len - 1])
            return len;

        return 0;
    }
};
