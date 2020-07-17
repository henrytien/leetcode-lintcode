#include"AllInclude.h"
class Solution {
public:
	int romanToInt(string s) {
		int res = 0;
		char I = 'I', V = 'V', X = 'X', L = 'L', C = 'C', D = 'D', M = 'M';
		for (size_t i = 0; i < s.length();) 
		{
			int end = i + 1;
			if (s[i] == I && s[i + 1] == V && end < s.length()) // IV = 4
			{
				res += 4;
				i+=2;
			}
			else if (s[i] == I && s[i + 1] == X && end < s.length()) // IX = 9
			{
				res += 9;
				i+=2;
			}
			else if (s[i] == I)
			{
				res += 1;
				++i;
			}
			if (s[i] == V)
			{
				res += 5;
				i++;
			}
			
			if (s[i] == X && s[i + 1] == L && end < s.length()) // XL = 40
			{
				res += 40;
				i+=2;
			}
			else if (s[i] == X && s[i + 1] == C && end < s.length()) // XC = 90
			{
				res += 90;
				i += 2;
			}
			else if (s[i] == X)
			{
				res += 10;
				i++;
			}
			if (s[i] == L)
			{
				res += 50;
				++i;
			}
			if (s[i] == C && s[i + 1] == D && end < s.length()) // CD = 400
			{
				res += 400;
				i += 2;
			}
			else if (s[i] == C && s[i + 1] == M && end < s.length()) // CM = 900
			{
				res += 900;
				i+=2;
			}
			else if (s[i] == C)
			{
				res += 100;
				++i;
			}
			if (s[i] == D)
			{
				res += 500;
				++i;
			}
			if (s[i] == M)
			{
				res += 1000;
				i++;
			}
		}
		return res;
	}
};

int main()
{
	string s = "MCDLXXVI";

	cout << Solution().romanToInt(s);
	

	getchar();
	return 0;
}