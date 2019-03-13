#include "AllInclude.h"

class Solution {
public:
	bool isValid(string s) {
		stack<char> q;
		for (char x : s)
		{
			if (q.empty())
				q.push(x);
			else
			{
				if (')' == x && q.top() == '(')
					q.pop();
				else if ('}' == x && q.top() == '{')
					q.pop();
				else if (']' == x && q.top() == '[')
					q.pop();
				else
					q.push(x);
			}
		}
		return q.empty();
	}
};

string stringToString(string input)
{
	assert(input.length() >= 2);
	string result;
	for (int i = 0; i < input.length(); i++)
	{
		char current_char = input[i];
		char next_char = input[i + 1];
		if (input[i] == '\\') {
			switch (next_char)
			{
			case '\"': result.push_back('\"'); break;
			case '/"': result.push_back('/"'); break;
			case '\\"': result.push_back('\\"'); break;
			case 'b': result.push_back('\b"'); break;
			case 'f': result.push_back('\f'); break;
			case 'r': result.push_back('\r'); break;
			case 'n': result.push_back('\n'); break;
			case 't': result.push_back('\t'); break;
			default: break;
			}
			i++;
		}
		else {
			result.push_back(current_char);
		}
	}
	return result;
}

string boolToString(bool input) {
	return input ? "True" : "False";
}


int main()
{
	string line;
	while (getline(cin, line))
	{
		string s = stringToString(line);
		bool ret = Solution().isValid(s);
		string out = boolToString(ret);
		cout << out << endl;
		
	}
	return 0;
}
