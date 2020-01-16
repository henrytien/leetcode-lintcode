class Solution
{
public:
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    bool sequenceReconstruction(vector<int> &org, vector<vector<int>> &seqs)
    {

        unordered_map<int, int> pos, pre;
        // 处理原始顺序，0，1，2...
        for (int i = 0; i < org.size(); i++)
        {
            pos[org[i]] = i;
        }

        for (auto &seq : seqs)
        {
            for (int i = 0; i < seq.size(); i++)
            {
                if (pos.find(seq[i]) == pos.end())
                {
                    return false;
                }

                // 前一个序列大于等于后一个序列对应的值不可以
                // [[1,2],[1,3]]
                if (i > 0 && pos[seq[i - 1]] >= pos[seq[i]])
                {
                    return false;
                }
                // 取出对应的值放到前序map里，建立映射关系
                if (pre.find(seq[i]) == pre.end())
                {
                    pre[seq[i]] = (i > 0) ? pos[seq[i - 1]] : -1; // 1,2...
                }
                else
                {
                    pre[seq[i]] = max(pre[seq[i]], (i > 0) ? pos[seq[i - 1]] : -1);
                }
            }
        }

        for (int i = 0; i < org.size(); i++)
        {
            if (pre[org[i]] != i - 1)
            {
                return false;
            }
        }

        return true;
    }
};