// https://www.lintcode.com/problem/two-sum-ii-input-array-is-sorted/description?_from=ladder&&fromId=1
class Solution
{
public:
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &nums, int target)
    {
        int count = nums.size();
        vector<int> res;
        if (count == 0)
        {
            return res;
        }
        unordered_map<int, int> myHash;
        for (int i = 0; i < count; i++)
        {
            myHash[nums[i]] = i + 1;
        }

        for (int i = 0; i < count; i++)
        {
            int value = target - nums[i];
            if (myHash.count(value) && myHash[value] != i)
            {
                res.emplace_back(i + 1);
                res.emplace_back(myHash[value]);
                break;
            }
        }

        return res;
    }
};

// two pointer
class Solution
{
public:
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    vector<int> twoSum(vector<int> &nums, int target)
    {
        int count = nums.size();
        vector<int> res;
        if (count == 0 || count == 1)
        {
            return res;
        }
        int start = 0, end = count - 1;
        while (start < end)
        {
            if (nums[start] + nums[end] == target)
            {
                res.emplace_back(start + 1);
                res.emplace_back(end + 1);
            }
            if (nums[start] + nums[end] < target)
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return res;
    }
};