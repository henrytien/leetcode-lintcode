// Source : https://leetcode.com/problems/multiply-strings/
// Author : henrytien
// Date   : 2022-01-08

/*****************************************************************************************************
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1
 * and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Constraints:
 *
 * 	1 <= num1.length, num2.length <= 200
 * 	num1 and num2 consist of digits only.
 * 	Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    string multiply(string num1, string num2)
    {
        if (num1.length() == 0 || num2.length() == 0)
        {
            return "";
        }
        if ((num1.length() == 1 && num1[0] == '0') ||(num2.length() == 1 && num2[0] == '0'))
        {
            return "0";
        }
        
        map<int, vector<int> > add_map; // For every num to store the temp value.
        
        for (int i = num2.length()-1; i >= 0; --i)
        {
            int n2 = num2[i] - '0';
            int res = 0;
            int t = 0; // More than ten should add 1.
            vector<int> value;
            for (int j = num1.length()-1; j >= 0; --j)
            {
                int n1 = num1[j] - '0';
                int num = n1 * n2 + t;
                value.insert(value.begin(),num % 10);
                t = num / 10;
            }
            if (t != 0)
            {
                value.insert(value.begin(),t);
            }
            
            add_map.insert(make_pair(num2.length() - i, value));
        }
        return AddStringNum(add_map);
    }

private:
    string AddStringNum(map<int, vector<int> > &res)
    {
        string ans = "";
        vector<int> num(0);
        for (auto iter= res.begin(); iter != res.end();++iter)
        {
            Add(num,iter->second);
            if (num.size() != 0)
            {
                ans.insert(ans.begin(),num.back() +'0');
                num.pop_back();
            }
            
        }
        while (num.size() > 0)
        {
            ans = to_string(num.back()) + ans;
            num.pop_back();
        }
        
        
        return ans;
    }
    // Num2 added to num1.
    void Add(vector<int> &num1, vector<int> num2) {
        vector<int> ans(0);
        int t = 0;
        if (num1.size() >= 1)
        {
            for (int i = num1.size() - 1; i >= 0; i--)
            {
                int n1 = num1[i];
                if (num2.size() != 0)
                {
                    int num = n1 + num2.back() + t;
                    num2.pop_back();
                    ans.insert(ans.begin(),num % 10);
                    t = num / 10;
                }
            }
        }
        
        
        while (num2.size() > 0)
        {
            if(t!=0) {
                ans.insert(ans.begin(),num2.back()+t);
                num2.pop_back();
                t = 0;
            }
            if (num2.size() > 0)
            {
                 ans.insert(ans.begin(),num2.back());
                num2.pop_back();
            }
        }
        if (t > 0)
        {
             ans.insert(ans.begin(),t);
        }
        
        num1 = ans;
    }
};
int main()
{
    string num1 = "3", num2 = "38";

    cout << Solution().multiply(num1, num2) << endl;
    return 0;
}
