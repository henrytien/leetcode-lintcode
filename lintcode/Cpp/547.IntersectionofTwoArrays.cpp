// https://www.lintcode.com/problem/intersection-of-two-arrays/description

class Solution
{
public:
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    vector<int> intersection(vector<int> &nums1, vector<int> &nums2)
    {
        // write your code here
        unordered_map<int, int> hash;
        vector<int> res;
        for (int i = 0; i < nums1.size(); i++)
        {
            if (hash.count(nums1[i]) == 0)
            {
                hash[nums1[i]] = 1;
            }
        }

        for (int i = 0; i < nums2.size(); i++)
        {
            if (hash.count(nums2[i]) == 1)
            {
                res.push_back(nums2[i]);
                hash.erase(nums2[i]);
            }
        }
        
        return res;
    }
};