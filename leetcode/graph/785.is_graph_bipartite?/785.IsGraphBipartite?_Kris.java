// Source : https://leetcode.com/problems/is-graph-bipartite/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A 
 * and B, such that every edge in the graph has one node in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge 
 * between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are 
 * no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element 
 * twice.
 * 
 * Example 1:
 * 
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * 
 * Example 2:
 * 
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
 * 
 * Constraints:
 * 
 * 	1 <= graph.length <= 100
 * 	0 <= graphp[i].length < 100
 * 	0 <= graph[i][j] <= graph.length - 1
 * 	graph[i][j] != i
 * 	All the values of graph[i] are unique.
 * 	The graph is guaranteed to be undirected. 
 ******************************************************************************************************/

class Solution {
    // use color, 0: unpainted, 1: red, -1: green
    // 一个点不能被涂两种颜色 (属于两个 sets)
    public boolean isBipartite(int[][] graph) {
        var colors = new int[graph.length];
        
        for (var i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !bfs(graph, i, colors, 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean dfs(int[][] graph, int i, int[] colors, int color) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        
        colors[i] = color;
        for (var neighbor : graph[i]) {
            if (!dfs(graph, neighbor, colors, -color)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean bfs(int[][] graph, int i, int[] colors, int color) {
        var queue = new LinkedList<Integer>();
        queue.offer(i);
        colors[i] = color;
        
        while (!queue.isEmpty()) {
            var cur = queue.pop();
            
            for (var neighbor : graph[cur]) {
                if (colors[neighbor] == colors[cur]) {
                    return false;
                } else if  (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[cur];
                    queue.offer(neighbor);
                }
            }
        }
        
        return true;
    }
    
    
    // 将 i 和 graph[i] 分别放入两个 sets。如果一个点将被放入两个 sets，那么 return false
    public boolean isBipartite_use2sets(int[][] graph) {
        var setA = new HashSet<Integer>();
        var setB = new HashSet<Integer>();
        
        for (var i = 0; i < graph.length; i++) {
            if (!setA.contains(i) && !setB.contains(i)
                && !helper(graph, i, setA, setB)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean helper(int[][] graph, int i, Set<Integer> setA, Set<Integer> setB) {
        if (setA.contains(i)) {
            return true;
        }
        
        if (setB.contains(i)) {
            return false;
        }

        setA.add(i);
        for (var neighbor : graph[i]) {
            if (!helper(graph, neighbor, setB, setA)) {
                return false;
            }
        }
        
        return true;
    }
}