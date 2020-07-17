#include"AllInclude.h"
// 如何理解摩尔投票算法？https://www.zhihu.com/question/49973163
class Solution {
public:
	int majorityElement(vector<int>& nums) {
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.size(); i++)
		{
			if (count == 0) {
				++count;
				major = nums[i];
			}
			else if (major == nums[i]) {
				++count;
			}
			else
			{
				--count;
			}
		}
		return major;
	}
};



int main()
{
	//vector<int> src = { 2,2,1,1,1,2,2 };
	vector<int> src = {3,2,3};
//	vector<int> src = { 6, 5, 5 };
	cout << Solution().majorityElement(src);
	getchar();
	return 0;

}