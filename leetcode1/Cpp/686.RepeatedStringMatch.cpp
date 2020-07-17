//https://leetcode.com/problems/repeated-string-match/
#include"AllInclude.h"


class Solution {
public:
	int repeatedStringMatch(string A, string B) {
		for (auto i = 0, j = 0; i < A.size(); ++i) {
        for (j = 0; j < B.size() && A[(i + j) % A.size()] == B[j]; ++j);
        if (j == B.size()) return (i + j) / A.size() + ((i + j) % A.size() != 0 ? 1 : 0);
    }
    return -1;
	}
};





int main()
{

	string a = "abcdabcdabcd", b = "abcdabcd";

	cout<< Solution().repeatedStringMatch(a,b);
	

	getchar();
	return 0;
}