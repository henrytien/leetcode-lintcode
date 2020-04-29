#include"ac.h"
//https://leetcode.com/problems/plus-one/

// Time complexity: O(n)
// Space complexity: O(n)
class Solution1
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        int carry = 1;
        for (int i = digits.size() - 1; i >= 0; --i)
        {
            carry += digits[i];
            digits[i] = carry % 10;
            carry = carry / 10;
        }
        if (carry)
        {
            digits.insert(digits.begin(), carry);
        }
        return digits;
    }
};


class Solution
{
public:
    vector<int> plusOne(vector<int> &digits)
    {
        for (int i = digits.size(); i--; digits[i] = 0)
        {
            if (digits[i]++ < 9)
            {
                return digits;
            }
        }
        digits[0]++;
        digits.push_back(0);
        return digits;
    }
};