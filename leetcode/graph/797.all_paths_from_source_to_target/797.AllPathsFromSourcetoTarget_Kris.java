// Source : https://leetcode.com/problems/all-paths-from-source-to-target/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths 
 * from node 0 to node n - 1, and return them in any order.
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., 
 * there is a directed edge from node i to node graph[i][j]).
 * 
 * Example 1:
 * 
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * Example 2:
 * 
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 
 * Example 3:
 * 
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * 
 * Example 4:
 * 
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * 
 * Example 5:
 * 
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 * 
 * Constraints:
 * 
 * 	n == graph.length
 * 	2 <= n <= 15
 * 	0 <= graph[i][j] < n
 * 	graph[i][j] != i (i.e., there will be no self-loops).
 * 	The input graph is guaranteed to be a DAG.
 ******************************************************************************************************/

class Solution {
    // directed acyclic graph (DAG) 有向无环图，无环所以不需要 visit 数组。。
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var result = new ArrayList<List<Integer>>();
        
        dfs(graph, 0, /*new boolean[graph.length],*/ new ArrayList<Integer>(), result);
        return result;
    }
    
    void dfs(int[][] graph, int i, /* boolean[] visit, */
             List<Integer> one, List<List<Integer>> result) {
        if (i == graph.length - 1) {
            var tmp = new ArrayList<Integer>(one);
            tmp.add(i);
            result.add(tmp);
            return;
        }
        
        // visit[i] = true;
        one.add(i);
        
        for (var neighbor : graph[i]) {
            // if (!visit[neighbor]) {
                dfs(graph, neighbor, /*visit,*/ one, result);
            // }
        }
        
        one.remove(one.size() - 1);
        // visit[i] = false;
    }
}