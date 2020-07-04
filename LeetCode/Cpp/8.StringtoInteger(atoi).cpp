#include"AllInclude.h"
// https://leetcode.com/problems/string-to-integer-atoi/
//4 2019��8��7��23:32:26
class Solution {
public:
	int myAtoi(string str) {
        int i = 0, flag = 1;
		long ans = 0;
		while (str[i] == ' ') i++;
		if (str[i] == '-' || str[i] == '+')
			flag = str[i++] == '-' ? -1 : 1;
		while (isdigit(str[i]))
		{
			ans = ans * 10 + (str[i++] - '0');
			if (flag == 1 && ans >= INT_MAX) return INT_MAX;
			if (flag == -1 && -ans <= INT_MIN) return INT_MIN;
		}
		return flag == 1 ? ans : -ans;
    }

	int myAtoi2(string str) {
		long long result = 0;
		int sign = 0;
		for (int i = 0; i < str.length();)
		{
			i = str.find_first_not_of(' ');
			if (str[i] == '-' || str[i] == '+')
				sign = str[i++] == '-' ? -1 : 1;
			while ('0' <= str[i]  && str[i] <= '9')
			{
				result = 10 * result + (str[i++] - '0');
				if (result * sign >= INT_MAX) return INT_MAX;
				if (result * sign <= INT_MIN) return INT_MIN;
			}
		}
		return result;
	}


	int myAtoi1(string str) {

		char *s = const_cast<char *>(str.c_str());
		while (*s && isspace(*s)) //skip space
			++s;
		int n = 0;
		if (*s) {
			int sign = 1;
			if (*s == '+')
				++s;
			else if (*s == '-') {
				sign = -1;
				++s;
			}

			while (*s && isdigit(*s))
			{
				int oldn = n;
				n = n * 10 + *s++ - '0';
				if (n / 10 != oldn)
				{
					if (sign < 0)
						return INT_MIN;
					else
						return INT_MAX;
				}
			}
			n *= sign;
		}
		return n;
	}
};

class Solution {
public:
    int myAtoi(string str) {
        int i = 0;
        int res = 0;
        int flag = 1;
        // 检查空格
        while(str[i] == ' ')
        {
            ++i;
        }

        // 检查正负号
        if(str[i] == '-')
        {
            flag = -1;
        }
        if(str[i] == '+' || str[i] == '-')
        {
            ++i;
        }

        // 判断数字并计算
        while(i < str.size() && isdigit(str[i]))
        {
            int r = str[i] - '0';

            // 判断是否会溢出
            if( res > INT_MAX / 10 || (res == INT_MAX/10 && r > 7))
            {
                return flag > 0 ? INT_MAX:INT_MIN;
            }
            res = res*10 + r;
            ++i;
        }
        
        return flag == 1 ? res :-res;
    }
};

int main()
{
	char *str = "+1300";
	cout << Solution().myAtoi(str);
	cout << Solution().myAtoi2(str);
	cout << Solution().myAtoi1(str);
	getchar();
	return 0;
}