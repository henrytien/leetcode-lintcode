// https://www.lintcode.com/problem/hash-function/description
// 同余定理，注意存储
class Solution
{
public:
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    int hashCode(string &key, int HASH_SIZE)
    {
        long id = 0;
        for (int i = 0; i < key.size(); i++)
        {
            id = (id * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)id;
    }
};