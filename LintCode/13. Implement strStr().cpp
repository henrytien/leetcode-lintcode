
//https://www.lintcode.com/problem/implement-strstr/description?_from=ladder&&fromId=1
class Solution
{
public:
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    int strStr(string &source, string &target)
    {
        int lens = source.length(), lent = target.length();
        int i, j;
        if (lent == 0)
        {
            return 0;
        }
        for (i = 0; i <= lens - lent; i++)
        {
            for (j = 0; j < lent; j++)
            {
                if (source[i + j] != target[j])
                {
                    break;
                }
                if (j == lent - 1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
};