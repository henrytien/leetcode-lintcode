//https://www.lintcode.com/problem/course-schedule/description?_from=ladder&&fromId=1
class Solution
{
public:
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    bool canFinish(int numCourses, vector<pair<int, int>> &prerequisites)
    {
        if (prerequisites.size() == 0)
        {
            return true;
        }

        vector<unordered_multiset<int>> edges(numCourses);
        vector<int> d(numCourses, 0);
        for (int i = 0; i < prerequisites.size(); i++)
        {
            edges[prerequisites[i].second].insert(prerequisites[i].first);
            d[prerequisites[i].first]++; // 统计该点的度
            //std::cout << prerequisites[i].second  << prerequisites[i].first << std::endl;
        }

        std::queue<int> q;
        for (int i = 0; i < numCourses; i++)
        {
            if (d[i] == 0)
            {
                q.push(i);
            }
        }

        //bfs
        int node = 0;
        while (!q.empty())
        {
            int x = q.front();
            q.pop();
            node++;
            for (auto iter = edges[x].begin(); iter != edges[x].end(); ++iter)
            {
                --d[*iter];
                if (d[*iter] == 0)
                {
                    std::cout << *iter << std::endl;
                    q.push(*iter);
                }
            }
        }
        return node == numCourses;
    }
};