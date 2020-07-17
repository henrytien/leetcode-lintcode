#include"AllInclude.h"
//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
public:
	vector<int> topKFrequent(vector<int>& nums, int k) {
		unordered_map<int, int> m;
		vector<int> ret;
		for (int num : nums)
			++m[num];
		return ret;
	}
};


int main() {
	vector<int> nums = { 1,1,1,2,2,3 };
	int k = 2;
	for (auto &iter:Solution().topKFrequent(nums,k))
	{
		cout << iter << " ";
	}

	return 0;
}