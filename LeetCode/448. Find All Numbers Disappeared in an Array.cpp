#include"AllInclude.h"
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
public:
	vector<int> findDisappearedNumbers(vector<int>& nums) {
		auto size = nums.size();
		vector<int> ret;
		for (int i = 0; i < size; i++)
			while (nums[nums[i] - 1] != nums[i])
				swap(nums[nums[i]-1], nums[i]);

		for (int i = 0; i < size; i++)
			if (i+1 != nums[i])
				ret.emplace_back(i+1);
		return ret;
	}
};


int main()
{
	vector<int> a = { 4, 3, 2, 7, 8, 2, 3, 1 };
	for (auto &iter : Solution().findDisappearedNumbers(a))
		cout << iter << " ";
	getchar();
	return 0;
}