#include"AllInclude.h"
//https://leetcode.com/problems/buddy-strings/

class Solution {
public:
	bool buddyStrings(string A, string B) {

		string tmpa = "", tmpb = "";
		if (A.length() != B.length()) return false;
		if (A == B && set<char>(A.begin(), A.end()).size() < A.size()) return true;
		vector<int> diff;
		for (int i = 0; i < A.length(); ++i)
			if (A[i] != B[i]) diff.push_back(i);
		return diff.size() == 2 && A[diff[0]] == B[diff[1]] && A[diff[1]] == B[diff[0]];
	}
};
int main()
{
	string A = "abcd" , B="badc";

	cout << Solution().buddyStrings(A, B);


	getchar();
	return 0;
}