//[15. 3Sum](https://leetcode.com/problems/3sum/description/)

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using  std::vector;
using  std::sort;
using namespace std;
class Solution {
public:
	vector<vector<int>> threeSum(vector<int>& nums)
	{
		if (nums.size() < 3)
			return{};

		sort(nums.begin(), nums.end());
		vector<vector<int>> result;
		int i = 0;
		int last = nums.size() - 1;

		while (i < last)
		{
			int a = nums[i], j = i + 1;
			while (j < last) {
				int b = nums[j], c = nums[last], sum = a + b + c;
				if (sum == 0) result.push_back({ nums[i], b, c });
				if (sum <= 0) while (nums[j] == b && j < last) j++;
				if (sum >= 0) while (nums[last] == c && j < last) last--;
			}
			while (nums[i] == a && i < last) i++;
		}
		return result;
	}
};

int main() {
	Solution a;
	vector<int> nums({ -1, 0, 1, 2, -1, -4 });
	vector<vector<int>> result = a.threeSum(nums);
	for (auto element : result)
	{
		std::string res;
		for (auto e : element)
		{
			res += " " + std::to_string(e);
		}
		std::cout << res << endl;
	}
	std::cout << "Hello, World!" << std::endl;
	return 0;
}




