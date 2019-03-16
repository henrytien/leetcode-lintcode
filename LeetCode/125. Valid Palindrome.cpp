#include"AllInclude.h"
//https://leetcode.com/problems/valid-palindrome/
class Solution {
public:
	bool isPalindrome(string s) {
		int start = 0, end = s.length() - 1;
		while (start < end)
		{
			if (!isalnum(s[start]))  start++;
			else if (!isalnum(s[end])) end--;
			else if (tolower(s[start++]) != tolower(s[end--])) return false;
		}
		return true;
	}
};
int main()
{
	string A = "race a car";

	cout << Solution().isPalindrome(A);


	getchar();
	return 0;
}